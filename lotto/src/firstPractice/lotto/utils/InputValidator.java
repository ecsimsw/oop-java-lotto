package lotto.utils;

import lotto.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String NUMBER_DUPLICATED_ERROR = "중복된 숫자를 포함할 수 없습니다.";
    private static final String INVALID_LENGTH_ERROR = "잘못된 길이의 로또 번호입니다.";
    private static final String INVALID_RANGE_ERROR = "잘못된 범위의 로또 번호입니다.";
    private static final String NOT_NUMERIC_ERROR = "숫자가 아닌 입력입니다.";
    private static final String ALREADY_USED_NUMBER = "이미 사용된 로또 번호입니다.";

    private InputValidator() {
    }

    public static void checkAllNumeric(String[] input) {
        boolean isAllNumeric = Arrays.stream(input)
                .allMatch(n -> StringHandler.isNumeric(n));

        if (!isAllNumeric) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    public static void checkIsNumeric(String input) {
        if (!StringHandler.isNumeric(input)) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    public static void checkIsValidLotto(List<Integer> numbers) {
        isDuplicate(numbers);
        isValidLength(numbers, Lotto.LEN);
        isValidNumberList(numbers, Lotto.MIN, Lotto.MAX);
    }

    public static void checkIsValidWinningLotto(Lotto winningLotto, int bonus) {
        isValidNumber(bonus, Lotto.MIN, Lotto.MAX);
        isAlreadyUsed(winningLotto, bonus);
    }

    private static void isAlreadyUsed(Lotto winningLotto, int bonus) {
        if (winningLotto.contains(bonus)) {
            throw new IllegalArgumentException(ALREADY_USED_NUMBER);
        }
    }

    private static void isDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED_ERROR);
        }
    }

    private static void isValidLength(List<Integer> numbers, int len) {
        if (numbers.size() != len) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR);
        }
    }

    private static void isValidNumber(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    private static void isValidNumberList(List<Integer> numbers, int min, int max) {
        if (!numbers.stream().allMatch(num -> num >= min && num <= max)) {
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }
    }
}