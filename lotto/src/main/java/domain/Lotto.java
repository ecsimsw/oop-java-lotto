package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int NUMBER_OF_NUMBERS = 6;

    private static final Money price = new Money(1000);

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void printNumbers(){
        System.out.println(numbers.toString());
    }

    public static int getAvailableCountBy(Money userAmount){
        return Money.divide(userAmount, price);
    }
}
