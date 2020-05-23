package com.nikolai.sfgpetclinic.services.map;

import com.nikolai.sfgpetclinic.model.Vet;
import com.nikolai.sfgpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractServiceMap<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}