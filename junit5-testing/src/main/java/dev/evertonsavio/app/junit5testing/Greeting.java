package dev.evertonsavio.app.junit5testing;

public class Greeting {

    private static final String HELLO = "Olá";
    private static final String WORLD = "Mundo!";

    public static String helloWorld() {
        return HELLO + " " + WORLD;
    }

    public static String helloWorld(String name) {
        return HELLO + " " + name;
    }
}
