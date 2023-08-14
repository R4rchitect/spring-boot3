package com.teamra.appwswhisper.shared.domain.repository;

public interface CrudRepository<T> {

    T findById(Integer id);

    void insert(T object);

    T update(T object);

    T removeById(Integer id);
    
}
