package dev.evertonsavio.app.junit5testing.standard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatingTest {

    private Greating greating;

    @BeforeEach
    void setUp() {
        System.out.println("Executa antes de cada...");
        greating = new Greating();
    }

    @Test
    void helloWorld() {
        //greating = new Greating();
        System.out.println(greating.helloWorld());
    }

    @Test
    void testHelloWorld() {
        //Greating greating = new Greating();
        System.out.println(greating.helloWorld("Savio"));

    }
}