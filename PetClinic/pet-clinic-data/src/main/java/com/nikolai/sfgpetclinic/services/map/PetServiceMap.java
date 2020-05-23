package com.nikolai.sfgpetclinic.services.map;

import com.nikolai.sfgpetclinic.model.Pet;
import com.nikolai.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractServiceMap<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
