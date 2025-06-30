package com.modulithhexagonaldddsample.catalog.adapter.in.web;

import com.modulithhexagonaldddsample.catalog.application.port.in.CreateProductUseCase;
import com.modulithhexagonaldddsample.catalog.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public ResponseEntity<Product> create(@RequestParam String name, @RequestParam BigDecimal price) {
        logger.info("Creating product with name: {} and price: {}", name, price);
        Product product =  createProductUseCase.create(name, price);
        return  ResponseEntity.ok().body(product);
    }
}