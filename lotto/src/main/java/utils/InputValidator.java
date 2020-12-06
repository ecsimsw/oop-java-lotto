package utils;
import domain.Lotto;

import java.util.List;

public class InputValidator {
    private InputValidator(){}

    public static void checkValidLotto(List<Integer> numbers){
        if(!isAllInRange(numbers, Lotto.MIN_NUM, Lotto.MAX_NUM)){
            throw new IllegalArgumentException("잘못된 범위의 로또 숫자입니다.");
        }

        if(!isValidSize(numbers, Lotto.NUMBER_OF_NUMBERS)){
            throw new IllegalArgumentException("로또 숫자 개수와 다릅니다.");
        }

        if(!isNonDuplicated(numbers)){
            throw new IllegalArgumentException("로또 번호는 중복 되어선 안됩니다");
        }
    }

    public static void checkValidMoney(int money){
        if(!isInRange(money, 0, Integer.MAX_VALUE)){
            throw new IllegalArgumentException("잘못된 범위의 금액입니다.");
        }
    }

    public static void checkValidWinningLotto(Lotto lotto, int bonusNumber){
        if(!isInRange(bonusNumber, Lotto.MIN_NUM, Lotto.MAX_NUM)){
            throw new IllegalArgumentException("잘못된 범위의 보너스 숫자입니다.");
        }

        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException("이미 로또 번호에 포함된 숫자는 보너스 숫자가 될 수 없습니다.");
        }
    }

    private static boolean isAllInRange(List<Integer> numbers, int min, int max){
        return numbers.stream()
                .allMatch(num -> isInRange(num, min, max));
    }

    private static boolean isInRange(int number, int min, int max){
        return (number >= min && number <= max);
    }

    private static boolean isValidSize(List<Integer> numbers, int len){
        return numbers.size() == len;
    }

    private static boolean isNonDuplicated(List<Integer> numbers){
        return numbers.stream().distinct().count() == numbers.size();
    }
}
