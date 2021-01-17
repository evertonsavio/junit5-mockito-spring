package dev.evertonsavio.app.junit5testing.standard;

public class Greating {

    private static final String HELLO = "hello";
    private static final String WORLD = "world";

    public static String helloWorld() {
        return HELLO + " " + WORLD;
    }

    public static String helloWorld(String name) {
        return HELLO + " " + name;
    }
}
