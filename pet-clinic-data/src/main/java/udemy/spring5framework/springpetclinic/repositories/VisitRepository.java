package udemy.spring5framework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring5framework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
