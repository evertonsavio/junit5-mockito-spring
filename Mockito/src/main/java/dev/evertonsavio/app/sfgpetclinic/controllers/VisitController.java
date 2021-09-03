package dev.evertonsavio.app.sfgpetclinic.controllers;

import dev.evertonsavio.app.sfgpetclinic.fauxspring.WebDataBinder;
import dev.evertonsavio.app.sfgpetclinic.model.Pet;
import dev.evertonsavio.app.sfgpetclinic.model.Visit;
import dev.evertonsavio.app.sfgpetclinic.services.PetService;
import dev.evertonsavio.app.sfgpetclinic.services.VisitService;
import dev.evertonsavio.app.sfgpetclinic.fauxspring.BindingResult;

import javax.validation.Valid;
import java.util.Map;


public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadPetWithVisit(Long petId, Map<String, Object> model) {
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    public String initNewVisitForm(Long petId, Map<String, Object> model) {
        return "pets/createOrUpdateVisitForm";
    }

    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);

            return "redirect:/owners/{ownerId}";
        }
    }
}
