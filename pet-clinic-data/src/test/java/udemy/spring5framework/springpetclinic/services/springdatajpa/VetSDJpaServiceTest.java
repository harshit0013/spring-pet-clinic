package udemy.spring5framework.springpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import udemy.spring5framework.springpetclinic.model.Vet;
import udemy.spring5framework.springpetclinic.repositories.VetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
    @Mock
    VetRepository vetRepository;

    @InjectMocks
    VetSDJpaService service;

    Vet returnVet;


    @BeforeEach
    void setUp() {
        returnVet = Vet.builder().id(2L).build();
    }

    @Test
    void findAll() {
        Set<Vet> returnVetSet = new HashSet<>();
        returnVetSet.add(Vet.builder().id(4L).build());
        returnVetSet.add(Vet.builder().id(5L).build());

        when(service.findAll()).thenReturn(returnVetSet);

        Set<Vet> vets = service.findAll();
        assertEquals(2, vets.size());
    }

    @Test
    void findById() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.of(returnVet));
        Vet vet = service.findById(2L);
        assertNotNull(vet);
    }

    @Test
    void findByIdNotFound() {
        when(vetRepository.findById(anyLong())).thenReturn(Optional.empty());
        Vet vet = service.findById(2L);
        assertNull(vet);
    }

    @Test
    void save() {
        Vet vetToSave = Vet.builder().id(3L).build();
        when(vetRepository.save(any())).thenReturn(returnVet);
        Vet savedVet = service.save(vetToSave);
        assertNotNull(savedVet);
        verify(vetRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnVet);
        verify(vetRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(returnVet.getId());
        verify(vetRepository, times(1)).deleteById(anyLong());
    }
}