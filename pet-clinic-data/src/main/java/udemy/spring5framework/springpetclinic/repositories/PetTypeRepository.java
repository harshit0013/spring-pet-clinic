package udemy.spring5framework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring5framework.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
