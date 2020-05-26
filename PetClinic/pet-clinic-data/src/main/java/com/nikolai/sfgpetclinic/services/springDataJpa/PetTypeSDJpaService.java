package com.nikolai.sfgpetclinic.services.springDataJpa;

import com.nikolai.sfgpetclinic.model.Pet;
import com.nikolai.sfgpetclinic.model.PetType;
import com.nikolai.sfgpetclinic.repositories.PetRepository;
import com.nikolai.sfgpetclinic.repositories.PetTypeRepository;
import com.nikolai.sfgpetclinic.services.PetService;
import com.nikolai.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petService) {
        this.petTypeRepository = petService;
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> pets = new HashSet<>();
        petTypeRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
