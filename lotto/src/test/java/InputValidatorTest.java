import lotto.lotto.Lotto;
import lotto.utils.InputValidator;
import lotto.utils.LottoFactory;
import lotto.utils.StringHandler;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InputValidatorTest {

    @Test
    public void 사용자_로또_입력_유효_확인(){
        String input = "1,2,3,4,5,6,7";
        List tempList =StringHandler.toNumberList(input);
        InputValidator.checkIsValidLotto(tempList);
    }
}
