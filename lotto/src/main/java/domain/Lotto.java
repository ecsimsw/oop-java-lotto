package domain;

import utils.InputValidator;

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
        InputValidator.checkValidLotto(numbers);
        this.numbers = numbers;
    }

    public void printNumbers(){
        System.out.println(numbers.toString());
    }

    public static int getAvailableCountBy(Money userAmount){
        return Money.divide(userAmount, price);
    }

    public int getCountOfMatch(Lotto other){
        return (int)numbers.stream()
                .filter(number-> other.contains(number))
                .count();
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public Rank calculateRank(WinningLotto winningLotto){
        return winningLotto.match(this);
    }
}
