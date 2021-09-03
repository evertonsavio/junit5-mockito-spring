package dev.evertonsavio.app.sfgpetclinic.controllers;

import dev.evertonsavio.app.sfgpetclinic.services.VetService;
import dev.evertonsavio.app.sfgpetclinic.fauxspring.Model;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
