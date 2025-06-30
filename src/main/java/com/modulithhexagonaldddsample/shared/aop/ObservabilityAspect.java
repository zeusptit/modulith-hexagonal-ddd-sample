package com.modulithhexagonaldddsample.shared.aop;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObservabilityAspect {

    private final Tracer tracer;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ObservabilityAspect(Tracer tracer) {
        this.tracer = tracer;
    }

    @Around("execution(* com.modulithhexagonaldddsample..*Service.*(..))")
    public Object observeService(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();

        Span span = tracer.nextSpan().name(methodName).start();

        try (Tracer.SpanInScope scope = tracer.withSpan(span)) {
            logger.info("Start: {}", methodName);
            Object result = joinPoint.proceed();
            logger.info("Success: {}", methodName);
            return result;
        } catch (Exception e) {
            span.error(e);
            logger.error("Error in {}: {}", methodName, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }
}

