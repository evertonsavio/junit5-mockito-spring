package dev.evertonsavio.sfgpetclinic.controllers;

import dev.evertonsavio.sfgpetclinic.fauxspring.Model;
import dev.evertonsavio.sfgpetclinic.services.VetService;

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
