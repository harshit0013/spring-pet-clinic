package udemy.spring5framework.springpetclinic.services;

import udemy.spring5framework.springpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
