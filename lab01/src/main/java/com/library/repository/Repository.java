package com.library.repository;

import java.util.List;
import java.util.Optional;

/**
 * Generic CRUD repository (Interface Segregation + DRY via generics).
 */
public interface Repository<T, ID> {
    void save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void delete(ID id);
}
