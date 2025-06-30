package com.modulithhexagonaldddsample.catalog.adapter.out.jpa;

import com.modulithhexagonaldddsample.catalog.adapter.out.entity.ProductEntity;
import com.modulithhexagonaldddsample.catalog.application.port.out.ProductRepository;
import com.modulithhexagonaldddsample.catalog.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProductRepositoryAdapter implements ProductRepository {
    private final ProductJpaRepository jpaRepository;

    public ProductRepositoryAdapter(ProductJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return jpaRepository.findById(id).map(ProductEntity::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntity.fromDomain(product);
        return jpaRepository.save(entity).toDomain();
    }
}
