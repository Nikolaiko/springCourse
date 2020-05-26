package com.nikolai.sfgpetclinic.repositories;

import com.nikolai.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
