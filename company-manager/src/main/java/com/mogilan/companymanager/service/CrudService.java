package com.mogilan.companymanager.service;

import java.util.List;
import java.util.Optional;

public interface CrudService <T, K>{
    T create(T newEntity);
    List<T> readAll();
    T readById(K id);
    boolean update(K id, T entity);
    boolean deleteById(K id);
}
