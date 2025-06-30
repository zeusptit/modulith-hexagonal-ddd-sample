package com.modulithhexagonaldddsample.catalog.adapter.out.jpa;

import com.modulithhexagonaldddsample.catalog.adapter.out.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {
}
