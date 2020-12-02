package lotto.utils;

import lotto.lotto.Lotto;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String NUMBER_DUPLICATED_ERROR = "중복된 숫자를 포함할 수 없습니다.";
    private static final String INVALID_LENGTH_ERROR = "잘못된 길이의 로또 번호입니다.";
    private static final String INVALID_RANGE_ERROR = "잘못된 범위의 로또 번호입니다.";
    private static final String NOT_NUMERIC_ERROR = "숫자가 아닌 입력입니다.";
    private static final String ALREADY_USED_NUMBER = "이미 사용된 로또 번호입니다.";

    private InputValidator(){}

    public static void checkIsValidLotto(List<Integer> numbers){
        checkIsDuplicated(numbers);
        checkIsValidLength(numbers, Lotto.LEN);
        checkIsInRange(numbers, Lotto.MIN, Lotto.MAX);
    }

    public static void checkIsValidWinningLotto(Lotto winningLotto, int bonus){
        checkIsInRange(bonus, Lotto.MIN, Lotto.MAX);
        checkAlreadyUsed(winningLotto, bonus);
    }

    private static void checkAlreadyUsed(Lotto winningLotto, int bonus){
        if(winningLotto.contains(bonus)){
            throw new IllegalArgumentException(ALREADY_USED_NUMBER);
        }
    }

    private static void checkIsInRange(int number, int min, int max){
        if(number < min || number > max){
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }

    private static void checkIsDuplicated(List<Integer> numbers){
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException(NUMBER_DUPLICATED_ERROR);
        }
    }

    private static void checkIsValidLength(List<Integer> numbers, int len){
        if(numbers.size() != len){
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR);
        }
    }

    private static void checkIsInRange(List<Integer> numbers, int min, int max){
        if(!numbers.stream().allMatch(num -> num >= min && num <= max)){
            throw new IllegalArgumentException(INVALID_RANGE_ERROR);
        }
    }

    public static void checkAllNumeric(String input){
        boolean isAllNumeric = Arrays.stream(input.split(InputView.SEPARATOR_NUMBERS))
                .allMatch(n-> StringHandler.isNumeric(n));

        if(!isAllNumeric){
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
        }
    }
}
