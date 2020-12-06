package domain;

public class Money {
    private final int money;

    public Money(int money){
        this.money = money;
    }

    public static int divide(Money a, Money b){
        return a.money / b.money;
    }
}
