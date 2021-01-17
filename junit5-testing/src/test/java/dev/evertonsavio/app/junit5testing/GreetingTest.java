package dev.evertonsavio.app.junit5testing;

import dev.evertonsavio.app.junit5testing.Greeting;
import org.junit.jupiter.api.*;

class GreetingTest {

    Greeting greeting;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Eu só sou executado uma unica vez no inicio!");

    }

    @BeforeEach
    void setUp() {
        System.out.println("Executa antes de cada...");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        //greating = new Greating();
        System.out.println(greeting.helloWorld());
    }

    @Test
    void testHelloWorld() {
        //Greating greating = new Greating();
        System.out.println(greeting.helloWorld("Savio"));

    }

    @AfterEach
    void tearDown(){
        System.out.println("Depois de cada...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Eu sou executado uma unica vez no final!");
    }
}