package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
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

        //assertJ Dependency
        assertThat(controller.index()).isEqualTo("index");
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

    @Test
    void testAssumptionTrue(){

        assertTrue("SAVIO".equalsIgnoreCase(System.getenv("SAVIO_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionTrue(){

        assertTrue("SAVIO".equalsIgnoreCase("SAVIO"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testOnMac(){}

    @Test
    @EnabledOnOs(OS.LINUX)
    void testOnLinux(){}

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeJava8(){
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeJava11(){
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "havyx")
    void testIfUserHavyx(){}

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "jonh")
    void testIfUserJonh(){}

}