package udemy.spring5framework.springpetclinic.services;

import udemy.spring5framework.springpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
