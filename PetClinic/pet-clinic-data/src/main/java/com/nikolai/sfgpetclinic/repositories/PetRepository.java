package com.nikolai.sfgpetclinic.repositories;

import com.nikolai.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
