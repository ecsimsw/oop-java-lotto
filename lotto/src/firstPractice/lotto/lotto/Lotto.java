package lotto.lotto;

import lotto.utils.InputValidator;
import lotto.view.OutputView;

import java.util.List;

public class Lotto {
    // 로또의 MIN, MAX, LEN 정보를 다른 클래스에 중구난방으로 사용하지 않는다.
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int LEN = 6;
    private static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        InputValidator.checkIsValidLotto(numbers);
        this.numbers = numbers;
    }

    // getter를 사용하지 않도록 하기 위한 기능 소유 넘김
    public static int getNumberOfPurchase(int purchaseAmount) {
        return purchaseAmount / PRICE;
    }

    // contains은 기본 메소드명이므로 contains와 구분 될 수 있는 메소드가 낫지 않을까
    public boolean contains(int object) {
        return numbers.contains(object);
    }

    public int getMatchCount(Lotto lotto) {
        return (int)this.numbers.stream()
                .filter(n -> lotto.contains(n))
                .count();
    }

    // contains와 같은 기능인데 메소드명만 다르다.
    // 합치고 메소드 명을 바꾼다.
    public boolean isMatchBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public void printNumbers() {
        OutputView.printNumbers(numbers.toString());
    }
}