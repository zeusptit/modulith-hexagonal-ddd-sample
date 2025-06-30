package com.modulithhexagonaldddsample.catalog.application.port.in;

import com.modulithhexagonaldddsample.catalog.domain.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface CreateProductUseCase {
    Product create(String name, BigDecimal price);
}
