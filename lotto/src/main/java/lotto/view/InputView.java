package lotto.view;

import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.utils.InputValidator;
import lotto.utils.LottoFactory;
import lotto.utils.StringHandler;

import java.util.Scanner;

public class InputView {
    public static final String SEPARATOR_NUMBERS = ",";

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.\n";
    private static final String ASK_WINNING_NUMBERS  = "지난 주 당첨 번호를 입력해 주세요.\n";
    private static final String ASK_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.\n";

    private InputView(){}

    public static int getPurchaseAmount() {
        OutputView.printMsg(ASK_PURCHASE_AMOUNT);
        try {
            return getNumber();
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getPurchaseAmount();
        }
    }

    public static WinningLotto getWinningLotto() {
        Lotto lotto = getLottoNumber();
        try {
            int bonus = getBonusNumber();
            return new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getWinningLotto(lotto);
        }
    }

    // 보너스 볼 입력에 문제가 생긴 경우, lotto 번호는 유지한채 보너스 볼 입력만 수행한다.
    private static WinningLotto getWinningLotto(Lotto lotto) {
        try {
            int bonus = getBonusNumber();
            return new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException IAE){
            IAE.printStackTrace();
            return getWinningLotto(lotto);
        }
    }

    private static Lotto getLottoNumber() {
        OutputView.printMsg(ASK_WINNING_NUMBERS);
        try {
            return LottoFactory.createLotto(getInput());
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getLottoNumber();
        }
    }

    private static int getBonusNumber() {
        OutputView.printMsg(ASK_BONUS_NUMBERS);
        try {
            return getNumber();
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getBonusNumber();
        }
    }

    private static int getNumber() {
        String input = getInput();
        InputValidator.checkIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}
