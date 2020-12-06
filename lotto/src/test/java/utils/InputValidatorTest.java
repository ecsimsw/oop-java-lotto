package utils;

import domain.Lotto;
import domain.Money;
import domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void checkValidLotto() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4}));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4,5,6,7}));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 5}));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 46}));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(Arrays.asList(new Integer[]{-1, 2, 3, 4, 5, 46}));
        });

        new Lotto(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void checkValidMoney() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new Money(-1);
        });

        new Money(1000);
    }

    @Test
    void checkValidWinningLotto() {
        assertThrows(IllegalArgumentException.class,()->{
            new WinningLotto(new Lotto(Arrays.asList(new Integer[]{1,2,3,4,5,6})), 6);
        });

        assertThrows(IllegalArgumentException.class,()->{
            new WinningLotto(new Lotto(Arrays.asList(new Integer[]{1,2,3,4,5,6})), 76);
        });

        new WinningLotto(new Lotto(Arrays.asList(new Integer[]{1,2,3,4,5,6})), 7);
    }
}