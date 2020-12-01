package lotto.lotto;

import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public boolean contains(int object){
        return numbers.contains(object);
    }

    public int getMatchCount(Lotto lotto){
        return (int)this.numbers.stream().filter(n -> lotto.contains(n)).count();
    }

    public boolean isMatchBonus(int bonus){
        return numbers.contains(bonus);
    }

    public void printNumbers() {
        OutputView.printMsg("[");
        OutputView.printMsg(numbers.toString());
        OutputView.printMsg("]\n");
    }
}