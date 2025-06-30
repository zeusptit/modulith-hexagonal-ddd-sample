package com.modulithhexagonaldddsample.catalog.application.port.out;

import com.modulithhexagonaldddsample.catalog.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Optional<Product> findById(UUID id);
    Product save(Product product);
}
