package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicationDollar() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
    }

    @Test
    void testEqualityDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(8), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.savio(5));
    }

    @Test
    void testMultiplicationSavio() {
        Money five = Money.savio(5);
        assertEquals(Money.savio(10), five.times(2));
    }

    @Test
    void testEqualitySavio() {
        assertEquals(Money.savio(5), Money.savio(5));
        assertNotEquals(Money.savio(8), Money.savio(5));
    }
}
