package com.modulithhexagonaldddsample.catalog.adapter.out.entity;

import com.modulithhexagonaldddsample.catalog.domain.model.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    private UUID id;

    private String name;
    private BigDecimal price;

    public static ProductEntity fromDomain(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.id = product.getId();
        entity.name = product.getName();
        entity.price = product.getPrice();
        return entity;
    }

    public Product toDomain() {
        return new Product(id, name, price);
    }

    // Getters/Setters
}