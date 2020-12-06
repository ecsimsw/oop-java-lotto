package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    void getLottoList() {
        LottoList lottoList = LottoFactory.getLottoList(5);
        lottoList.print();
    }
}