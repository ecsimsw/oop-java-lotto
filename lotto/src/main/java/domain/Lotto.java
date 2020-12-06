package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int NUMBER_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
}
