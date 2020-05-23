package com.nikolai.sfgpetclinic.bootstrap;

import com.nikolai.sfgpetclinic.model.Owner;
import com.nikolai.sfgpetclinic.model.Vet;
import com.nikolai.sfgpetclinic.services.OwnerService;
import com.nikolai.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jordan");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Butchers");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Doctor");
        vet1.setLastName("House");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bitch");
        vet2.setLastName("Doctor");
        vetService.save(vet2);

        System.out.println("Owners count: " + ownerService.findAll().size());
        System.out.println("Vets count: " + vetService.findAll().size());
    }
}
