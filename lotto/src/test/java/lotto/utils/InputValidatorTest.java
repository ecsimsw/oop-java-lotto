package lotto.utils;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class InputValidatorTest {

    // 예외가 발생했는지를 확인해야할 경우
    @Test(expected = IllegalArgumentException.class)
    public void checkValidLotto(){
        String userInput = "1,2,3,4,5,5";
        List<Integer> list = StringHandler.toNumberList(userInput);
        InputValidator.checkIsValidLotto(list);
    }

    // 예외 발생이 없는지 확인해야하는 경우
    @Test
    public void checkTotalProfit(){
        try{
            List<Lotto> lottoList = new ArrayList<>();
            lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
            Lottos lottos = new Lottos(lottoList);

            WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(7,8,9,10,11,12)), 13);
            lottos.printProfit(winningLotto, 5000);
        } catch (Exception e){
            fail();
        }
    }

    // 로직 중간에 처리 경로를 확인하는 방법 :: fail로 원치 않는 처리 로직을 확인한다.
    @Test
    public void assertFail(){
        try{
            new Lotto(Arrays.asList(1,2,3,4,5,6,7,8));
            // 예외 발생 :: 이하 로직은 실행되선 안된다.
            fail();
        } catch (Exception e){
        }
    }

    // 값 동일 확인
    @Test
    public void assertEqualsTest(){
        Lotto myLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertEquals(true, myLotto.contains(1));
    }
}