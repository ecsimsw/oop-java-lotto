package utils;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static List<Lotto> getLottoList(int count){
        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < count){
            lottos.add(getLotto());
        }
        return lottos;
    }

    private static Lotto getLotto(){
        List<Integer> list = new ArrayList<>();
        while(list.size() < Lotto.NUMBER_COUNT){
            list.add(getNumberWithoutDuplicate(list));
        }
        return new Lotto(list);
    }

    private static int getNumberWithoutDuplicate(List<Integer> list){
        int rand;
        do{
            rand = RandomUtils.nextInt(Lotto.NUMBER_MIN, Lotto.NUMBER_MAX);
        }while(list.contains(rand));
        return rand;
    }
}
