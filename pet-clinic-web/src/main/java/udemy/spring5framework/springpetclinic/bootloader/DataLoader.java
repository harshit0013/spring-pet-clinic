package udemy.spring5framework.springpetclinic.bootloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.spring5framework.springpetclinic.model.Owner;
import udemy.spring5framework.springpetclinic.model.Vet;
import udemy.spring5framework.springpetclinic.services.OwnerService;
import udemy.spring5framework.springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets...");
    }
}