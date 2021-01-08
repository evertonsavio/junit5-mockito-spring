package dev.evertonsavio.app;

public class Reais extends Money{

    public Reais(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier){
        return new Reais(amount * multiplier, "BRA");
    }

}
