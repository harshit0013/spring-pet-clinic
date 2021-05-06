package udemy.spring5framework.springpetclinic.services;

import udemy.spring5framework.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
