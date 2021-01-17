package dev.evertonsavio.app.junit5testing.standard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreatingTest {

    @Test
    void helloWorld() {
        Greating greating = new Greating();
        System.out.println(greating.helloWorld());
    }

    @Test
    void testHelloWorld() {
        Greating greating = new Greating();
        System.out.println(greating.helloWorld("Savio"));

    }
}