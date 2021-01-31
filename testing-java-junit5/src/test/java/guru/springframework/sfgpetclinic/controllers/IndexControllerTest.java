package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test if View Name is returning")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view return!");
        assertEquals("index", controller.index(), () -> "Another expensive message!");
    }

    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }
}