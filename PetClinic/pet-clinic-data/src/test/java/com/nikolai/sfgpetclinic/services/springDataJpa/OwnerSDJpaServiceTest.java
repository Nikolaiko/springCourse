package com.nikolai.sfgpetclinic.services.springDataJpa;

import com.nikolai.sfgpetclinic.model.Owner;
import com.nikolai.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;


    Long ownerId = 1L;
    String ownerLastName = "Pesterev";
    String ownerCity = "Kotlin";
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(ownerId);
        owner.setCity(ownerCity);
        owner.setLastName(ownerLastName);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner findedOwner = ownerSDJpaService.findByLastName(ownerLastName);
        assertEquals(findedOwner.getLastName(), ownerLastName);
    }

    @Test
    void save() {
        Owner newOwner = Owner.builder()
                .firstName("Nikolai")
                .lastName("Baklanov")
                .build();
        when(ownerRepository.save(any())).thenReturn(newOwner);

        Owner savedOwner = ownerRepository.save(newOwner);
        assertEquals(newOwner, savedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().lastName("Barmin").build());
        owners.add(Owner.builder().lastName("Baklanov").build());

        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> findedOwners = ownerSDJpaService.findAll();

        assertNotNull(findedOwners);
        assertEquals(findedOwners.size(), 2);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner findedOwner = ownerSDJpaService.findById(ownerId);

        assertEquals(findedOwner.getId(), ownerId);
        assertEquals(findedOwner.getLastName(), ownerLastName);
        assertEquals(findedOwner.getCity(), ownerCity);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);
        verify(ownerRepository).deleteById(anyLong());
    }
}