package udemy.spring5framework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring5framework.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
