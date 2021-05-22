package udemy.spring5framework.springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import udemy.spring5framework.springpetclinic.model.Pet;
import udemy.spring5framework.springpetclinic.model.Vet;
import udemy.spring5framework.springpetclinic.repositories.PetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {
    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetSDJpaService service;

    Pet returnPet;

    @BeforeEach
    void setUp() {
        returnPet = Pet.builder().id(2L).build();
    }

    @Test
    void findAll() {
        Set<Pet> returnPets = new HashSet<>();
        returnPets.add(Pet.builder().id(3L).build());
        returnPets.add(Pet.builder().id(4L).build());

        when(service.findAll()).thenReturn(returnPets);
        Set<Pet> pets = service.findAll();
        assertEquals(2, pets.size());
    }

    @Test
    void findById() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.of(returnPet));
        Pet pet = service.findById(2L);
        assertNotNull(pet);
    }

    @Test
    void findByIdNotFound() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.empty());
        Pet pet = service.findById(2L);
        assertNull(pet);
    }

    @Test
    void save() {
        Pet petToSave = Pet.builder().id(3L).build();
        when(petRepository.save(any())).thenReturn(returnPet);
        Pet savedPet = service.save(petToSave);
        assertNotNull(savedPet);
        verify(petRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnPet);
        verify(petRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnPet.getId());
        verify(petRepository, times(1)).deleteById(anyLong());
    }
}