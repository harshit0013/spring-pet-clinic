package udemy.spring5framework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring5framework.springpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
