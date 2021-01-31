package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

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
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oupsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), ()-> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrompt(){
        assertTimeoutPreemptively(Duration.ofMillis(100), ()-> {
            Thread.sleep(2000);
            System.out.println("I got here 2390hflasd");
        });
    }

    

}