package domain;

import utils.InputValidator;

public class Money {
    private final int money;

    public Money(int money){
        InputValidator.checkValidMoney(money);
        this.money = money;
    }

    public static int divide(Money a, Money b){
        return a.money / b.money;
    }
}
