package dev.evertonsavio.app;

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
        assertEquals(Money.reais(6), Money.reais(6));
        assertNotEquals(Money.dollar(8), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.reais(5));
    }

    @Test
    void testMultiplicationReais() {
        Money five = Money.reais(5);
        assertEquals(Money.reais(10), five.times(2));
    }

    @Test
    void testEqualityReais() {
        assertEquals(Money.reais(5), Money.reais(5));
        assertNotEquals(Money.reais(8), Money.reais(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).getCurrency());
        assertEquals("BRA", Money.reais(1).getCurrency());
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}
