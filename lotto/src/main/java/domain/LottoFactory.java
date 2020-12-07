package domain;

import utils.RandomUtils;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
public class LottoFactory {
    private LottoFactory(){}

    public static Lotto createLotto(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < Lotto.NUMBER_OF_NUMBERS){
            numbers.add(getRandWithoutDuplicate(numbers));
        }
        return new Lotto(numbers);
    }

    private static int getRandWithoutDuplicate(List<Integer> list){
        int rand;
        do{
            rand = RandomUtils.nextInt(Lotto.MIN_NUM, Lotto.MAX_NUM);
        }while (list.contains(rand));
        return rand;
    }
}
