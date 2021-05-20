package udemy.spring5framework.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.spring5framework.springpetclinic.model.Speciality;
import udemy.spring5framework.springpetclinic.model.Vet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetMapServiceTest {
    VetMapService vetMapService;
    Set<Speciality> specialities;
    final Long vetId = 1L;

    @BeforeEach
    void setUp()
    {
        specialities = new HashSet<>();
        specialities.add(Speciality.builder().id(2L).build());
        vetMapService = new VetMapService(new SpecialityMapService());
        vetMapService.save(Vet.builder().id(vetId).specialities(specialities).build());
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetMapService.findAll();
        assertEquals(1, vets.size());
    }

    @Test
    void findById() {
        Vet vet = vetMapService.findById(vetId);
        assertEquals(vetId, vet.getId());
    }

    @Test
    void saveExistingId() {
        long id = 3L;
        Vet vet = Vet.builder().id(id).specialities(specialities).build();
        Vet savedVet = vetMapService.save(vet);
        assertEquals(id, savedVet.getId());
    }

    @Test
    void saveNoId()
    {
        Vet savedVet = vetMapService.save(Vet.builder().specialities(specialities).build());
        assertNotNull(savedVet);
        assertNotNull(savedVet.getId());
    }

    @Test
    void delete() {
        vetMapService.delete(vetMapService.findById(vetId));
        assertEquals(0, vetMapService.findAll().size());
    }

    @Test
    void deleteById() {
        vetMapService.deleteById(vetId);
        assertEquals(0, vetMapService.findAll().size());
    }
}