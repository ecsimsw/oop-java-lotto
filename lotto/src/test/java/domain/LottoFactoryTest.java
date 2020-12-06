package domain;

import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    @Test
    void getLottoList() {
        LottoList lottoList = LottoFactory.getLottoList(5);
        lottoList.printLottoList();
    }
}