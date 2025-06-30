package com.modulithhexagonaldddsample.catalog.application.service;

import com.modulithhexagonaldddsample.catalog.application.port.in.CreateProductUseCase;
import com.modulithhexagonaldddsample.catalog.application.port.out.ProductRepository;
import com.modulithhexagonaldddsample.catalog.domain.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(String name, BigDecimal price) {
        Product product = new Product(UUID.randomUUID(), name, price);
        return productRepository.save(product);
    }
}
