package lotto.utils;

import java.util.ArrayList;
import java.util.List;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

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

    public static Lotto createLotto(String input) {
        List numbers = StringHandler.toNumberList(input);
        return new Lotto(numbers);
    }
}
