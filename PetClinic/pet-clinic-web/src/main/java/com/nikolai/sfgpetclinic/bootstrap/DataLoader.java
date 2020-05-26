package com.nikolai.sfgpetclinic.bootstrap;

import com.nikolai.sfgpetclinic.model.*;
import com.nikolai.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtiesService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int typesCount = petTypeService.findAll().size();
        if (typesCount == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jordan");
        owner1.setAddress("Lenina 37, flat 7");
        owner1.setCity("Anadyr");
        owner1.setTelephone("123");

        Pet dogPet = new Pet();
        dogPet.setBirthDate(LocalDate.now());
        dogPet.setName("Dik");
        dogPet.setPetType(dog);
        dogPet.setOwner(owner1);
        owner1.getPets().add(dogPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Butchers");
        owner2.setAddress("Lenina 39, flat 7");
        owner2.setCity("Anadyr");
        owner2.setTelephone("123");

        Pet catPet = new Pet();
        catPet.setBirthDate(LocalDate.now());
        catPet.setName("Cat");
        catPet.setPetType(cat);
        catPet.setOwner(owner2);
        owner2.getPets().add(catPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(catPet);
        catVisit.setDescription("Cat Visit");
        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Doctor");
        vet1.setLastName("House");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bitch");
        vet2.setLastName("Doctor");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Owners count: " + ownerService.findAll().size());
        System.out.println("Vets count: " + vetService.findAll().size());
    }
}
