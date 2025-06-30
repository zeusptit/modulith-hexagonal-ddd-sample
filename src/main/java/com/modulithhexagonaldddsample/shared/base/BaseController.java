package com.modulithhexagonaldddsample.shared.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class BaseController<T, ID, D> {

    protected final BaseService<T, ID> service;

    protected BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        Optional<T> entity = service.findById(id);
        return entity.map(this::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        T entity = toEntity(dto);
        T saved = service.save(entity);
        return ResponseEntity.ok(toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto) {
        T entity = toEntity(dto);
        T updated = service.update(entity);
        return ResponseEntity.ok(toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        Optional<T> entity = service.findById(id);
        if (entity.isPresent()) {
            service.delete(entity.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Abstract methods for mapping between entity and DTO
    protected abstract D toDto(T entity);
    protected abstract T toEntity(D dto);
}