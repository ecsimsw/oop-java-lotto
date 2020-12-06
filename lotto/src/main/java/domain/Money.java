package domain;

import utils.InputValidator;

public class Money {
    private final int value;

    public Money(int value) {
        InputValidator.checkValidMoney(value);
        this.value = value;
    }

    public static int getEarningRate(Money used, Money prize) {
        return (int) ((prize.value / (double) used.value) * 100);
    }

    public static int getAvailableCount(Money holdMoney, Money price) {
        return holdMoney.value / price.value;
    }

    public static Money getUsedMoney(Money holdMoney, Money price) {
        int usedValue = (getAvailableCount(holdMoney, price) * price.value);
        return new Money(usedValue);
    }
}
