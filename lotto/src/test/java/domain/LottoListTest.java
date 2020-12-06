package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {

    @Test
    void printWinningResult() {
        LottoList lottoList = LottoFactory.getLottoList(500);
        Lotto lotto = new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        lottoList.printWinningResult(winningLotto);
    }
}