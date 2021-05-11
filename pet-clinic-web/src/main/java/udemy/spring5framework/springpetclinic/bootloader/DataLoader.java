package udemy.spring5framework.springpetclinic.bootloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.spring5framework.springpetclinic.model.*;
import udemy.spring5framework.springpetclinic.services.OwnerService;
import udemy.spring5framework.springpetclinic.services.PetTypeService;
import udemy.spring5framework.springpetclinic.services.SpecialityService;
import udemy.spring5framework.springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Blacker St");
        owner1.setCity("London");
        owner1.setTelephone("678291991");

        Pet mikesPet = new Pet();
        mikesPet.setName("Tutu");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");
        owner2.setAddress("123 Blacker St");
        owner2.setCity("London");
        owner2.setTelephone("678291991");

        Pet fionasCat = new Pet();
        fionasCat.setName("Kiti");
        fionasCat.setOwner(owner2);
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets...");
    }
}
