package guru.springframework;

public abstract class Money {

    protected int amount;

    public abstract Money times(int multiplier);

    public static Money dollar(int amount){
        return new Dollar((amount));
    }

    public static Money savio(int amount){
        return new Savio(amount);
    }

    public boolean equals(Object object){

        Money money = (Money) object;
        return amount == money.amount
                && this.getClass().equals(object.getClass());
    }
}
