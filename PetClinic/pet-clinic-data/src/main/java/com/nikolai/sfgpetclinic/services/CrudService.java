package com.nikolai.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T save(T object);

    Set<T> findAll();
    T findById(ID id);

    void delete(T object);
    void deleteById(ID id);
}
