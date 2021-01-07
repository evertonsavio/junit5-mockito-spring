package guru.springframework;

public class Savio extends Money{

    public Savio(int amount) {
        this.amount = amount;
    }

    public Money times(int multiplier){
        return new Savio( amount *= multiplier);
    }

}
