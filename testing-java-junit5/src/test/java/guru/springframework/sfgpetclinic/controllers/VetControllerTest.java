package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    SpecialtyService specialtyService;
    VetService vetService;
    VetController controller;


    @BeforeEach
    void setUp(){
        this.specialtyService = new SpecialityMapService();
        this.vetService = new VetMapService(specialtyService);
        this.controller = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Everton", "Savio", null);
        Vet vet2 = new Vet(1L, "Jonh", "Doe", null);

        vetService.save(vet1);
        vetService.save(vet2);

    }

    @Test
    @DisplayName("Test Vet Controller")
    void listVets() {

        Model model = new ModelMapImpl();

        String view = controller.listVets(model);

        assertEquals("vets/index", view);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelAttribute).size().isEqualTo(1);

    }
}