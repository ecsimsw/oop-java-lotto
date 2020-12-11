package view;

import domain.Lotto;

import java.util.List;

public class Out {
    private Out(){}

    public static void printLottoList(List<Lotto> lottoList){
        lottoList.stream()
                .forEach(lotto -> print(lotto.toString()+"\n"));
    }

    public static void print(Object msg){
        System.out.print(msg);
    }
}
