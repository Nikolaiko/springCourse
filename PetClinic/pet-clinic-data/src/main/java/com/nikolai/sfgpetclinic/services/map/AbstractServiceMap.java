package com.nikolai.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractServiceMap<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

    protected Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    protected T findById(ID id) {
        return map.get(id);
    }

    protected T save(ID id, T object) {
        return map.put(id, object);
    }

    protected void deleteById(ID id) {
        map.remove(id);
    }

    protected void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
