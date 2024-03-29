package dev.evertonsavio.app;

/**
 * Created by jt on 10/10/18.
 */
public class Sum implements Expression {
    final Money augmend;
    final Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.amount + addmend.amount;
        return new Money(amount, to);
    }
}
