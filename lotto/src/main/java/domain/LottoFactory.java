package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private LottoFactory(){}

    public static LottoList getLottoList(int count){
        List<Lotto> list = new ArrayList<>();
        while(list.size() < count){
            list.add(createLotto());
        }
        return new LottoList(list);
    }

    private static Lotto createLotto(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < Lotto.NUMBER_OF_NUMBERS){
            numbers.add(getNumberWithoutDuplicate(numbers));
        }
        return new Lotto(numbers);
    }

    private static int getNumberWithoutDuplicate(List<Integer> list){
        int rand =0;
        do{
            rand = RandomUtils.nextInt(Lotto.MIN_NUM, Lotto.MAX_NUM);
        }while(list.contains(rand));
        return rand;
    }
}
