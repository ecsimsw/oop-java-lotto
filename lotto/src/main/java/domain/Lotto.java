package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;
    public static final int NUMBER_COUNT = 6;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
}