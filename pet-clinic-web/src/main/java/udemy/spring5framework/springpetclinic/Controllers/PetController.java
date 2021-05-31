package udemy.spring5framework.springpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import udemy.spring5framework.springpetclinic.model.Owner;
import udemy.spring5framework.springpetclinic.model.PetType;
import udemy.spring5framework.springpetclinic.services.OwnerService;
import udemy.spring5framework.springpetclinic.services.PetService;
import udemy.spring5framework.springpetclinic.services.PetTypeService;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> popularPetTypes()
    {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId)
    {
        return ownerService.findById(ownerId);
    }

    @InitBinder("")
    public void initOwnerBinder(WebDataBinder webDataBinder)
    {
        webDataBinder.setDisallowedFields("id");
    }
}
