package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.WinningLotto;

public class LottoFactory {
    private LottoFactory(){}

    public static Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < count) {
            lottos.add(createRandomLotto());
        }
        return new Lottos(lottos);
    }

    private static Lotto createRandomLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Lotto.LEN) {
            numbers.add(getRandWithoutDuplicate(numbers));
        }
        return new Lotto(numbers);
    }

    private static int getRandWithoutDuplicate(List<Integer> numbers) {
        int rand;

        do {
            rand = RandomUtils.nextInt(Lotto.MIN, Lotto.MAX);
        } while (numbers.contains(rand));
        return rand;
    }

    public static Lotto createWinningLotto(String input){
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}