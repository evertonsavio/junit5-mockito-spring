package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicationDollar() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(new Dollar(10), product);
    }

    @Test
    void testEqualityDollar() {
        assertEquals(new Dollar(5), new Dollar(5));
        assertNotEquals(new Dollar(8), new Dollar(5));
    }

    @Test
    void testMultiplicationSavio() {
        Savio five = new Savio(5);
        Savio product = five.times(2);
        assertEquals(new Savio(10), product);
    }

    @Test
    void testEqualitySavio() {
        assertEquals(new Savio(5), new Savio(5));
        assertNotEquals(new Savio(8), new Savio(5));
    }
}
