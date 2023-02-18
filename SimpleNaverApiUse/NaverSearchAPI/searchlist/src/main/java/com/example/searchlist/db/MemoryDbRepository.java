package com.example.searchlist.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepository<T> {
    Optional<T> findById(int idx);

    List<T> listAll();

    T save(T entity);

    void deleteById(int idx);

}
