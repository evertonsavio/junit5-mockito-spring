package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions(){
        Person person = new Person(1l, "Joe", "Duck");
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Duck", person.getLastName()));
    }

    @Test
    void groupedAssertionMsgs(){
        Person person = new Person(1l, "Joe", "Duck");
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Duck", person.getLastName(), "Second name Fail"));
    }

}