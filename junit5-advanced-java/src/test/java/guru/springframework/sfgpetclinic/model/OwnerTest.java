package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions(){

        Owner owner = new Owner(1l,"Joe", "Duck");
        owner.setCity("Key West");
        owner.setTelephone("123123123");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "Primeiro nome não deu match!"),
                        () -> assertEquals("Duck", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity()),
                        () -> assertEquals("123123123", owner.getTelephone())
                ));

        //Hemcrest dependency
        assertThat(owner.getCity(), is("Key West"));
    }
}