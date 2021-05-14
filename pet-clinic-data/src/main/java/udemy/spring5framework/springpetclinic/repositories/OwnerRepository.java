package udemy.spring5framework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring5framework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}