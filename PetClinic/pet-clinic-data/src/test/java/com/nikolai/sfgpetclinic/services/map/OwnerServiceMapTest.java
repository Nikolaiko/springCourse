package com.nikolai.sfgpetclinic.services.map;

import com.nikolai.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    String ownerCity = "Anadyr";
    String ownerLastName = "Stepchenkov";
    Long ownerId = 1L;

    @BeforeEach
    public void prepare() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setCity(ownerCity);
        owner.setLastName(ownerLastName);
        owner.setId(ownerId);
        ownerServiceMap.save(owner);
    }

    @Test
    void save() {
        Owner secondOwner = Owner.builder().address("Omsk").lastName("Baklanov").build();
        Owner savedOwner = ownerServiceMap.save(secondOwner);
        assertEquals(secondOwner, savedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(ownerServiceMap.findAll().size(), 0);
    }

    @Test
    void delete() {
        Owner findedOwner = ownerServiceMap.findById(ownerId);
        ownerServiceMap.delete(findedOwner);
        assertEquals(ownerServiceMap.findAll().size(), 0);
    }

    @Test
    void findById() {
        Owner findedOwner = ownerServiceMap.findById(ownerId);
        assertEquals(findedOwner.getLastName(), ownerLastName);
        assertEquals(findedOwner.getCity(), ownerCity);
        assertEquals(findedOwner.getId(), ownerId);
    }

    @Test
    void findByLastName() {
        Owner findedOwner = ownerServiceMap.findByLastName(ownerLastName);
        assertNotNull(findedOwner);
        assertEquals(findedOwner.getLastName(), ownerLastName);
    }
}