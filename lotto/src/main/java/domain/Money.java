package domain;

public class Money {
    private final int value;

    public Money(int value){
        if(value<0){
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public static int getAvailableQuantity(Money product, Money amount){
        return amount.value / product.value;
    }

    public static Money getAmountUsed(Money product, Money amount){
        int used = product.value * getAvailableQuantity(product, amount);
        return new Money(used);
    }
}
