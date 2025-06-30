package com.modulithhexagonaldddsample.shared.base;

import java.util.Optional;
import java.util.List;

public abstract class BaseService<T, ID> {

    protected final BaseRepository<T, ID> repository;

    protected BaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.update(entity);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    // Optionally, add more common methods, e.g., findAll
    public List<T> findAll() {
        // Example implementation, override in concrete service if needed
        throw new UnsupportedOperationException("findAll not implemented");
    }
}