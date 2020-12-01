package lotto.lotto;

import java.util.List;

public class Lotto {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int LEN = 6;
    private static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static int getNumberOfPurchase(int purchaseAmount) {
        return purchaseAmount / PRICE;
    }
}