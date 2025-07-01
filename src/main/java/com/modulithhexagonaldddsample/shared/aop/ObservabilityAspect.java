package com.modulithhexagonaldddsample.shared.aop;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
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

    @Around("execution(* com.modulithhexagonaldddsample..service..*(..))")
    public Object traceServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Span span = tracer.nextSpan().name(methodName);

        try (Tracer.SpanInScope spanInScope = tracer.withSpan(span.start())) {
            logger.info("Started span for method {} - TraceId: {}, SpanId: {}",
                    methodName,
                    span.context().traceId(),
                    span.context().spanId());
            
            Object result = joinPoint.proceed();
            span.tag("outcome", "success");
            return result;
        } catch (Throwable t) {
            span.tag("outcome", "error");
            span.tag("error.type", t.getClass().getName());
            span.tag("error.message", t.getMessage());
            logger.error("Error in {}: {}", methodName, t.getMessage(), t);
            throw t;
        } finally {
            span.end();
        }
    }
}