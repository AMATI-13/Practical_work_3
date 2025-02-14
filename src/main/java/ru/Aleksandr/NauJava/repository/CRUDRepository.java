package ru.Aleksandr.NauJava.repository;

import java.util.List;

public interface CRUDRepository<T, ID> {
    void create(T entity);
    T read(ID id);
    void update(T entity);
    void delete(ID id);
    List<T> findAll();
}