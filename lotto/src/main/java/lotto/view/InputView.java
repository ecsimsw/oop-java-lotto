package lotto.view;

import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.utils.LottoFactory;
import lotto.utils.StringHandler;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.\n";
    private static final String ASK_WINNING_NUMBERS  = "지난 주 당첨 번호를 입력해 주세요.\n";
    private static final String ASK_Bonus_NUMBERS  = "보너스 볼을 입력해 주세요.\n";

    private InputView(){}

    public static int getPurchaseAmount() {
        OutputView.printMsg(ASK_PURCHASE_AMOUNT);
        try {
            return Integer.parseInt(getInput());
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getPurchaseAmount();
        }
    }

    public static WinningLotto getWinningLotto() {
        Lotto winningLotto = getWInningNumber();
        int bonus = getBonusNumber();

        return new WinningLotto(winningLotto, bonus);
    }

    private static Lotto getWInningNumber() {
        OutputView.printMsg(ASK_WINNING_NUMBERS);

        return LottoFactory.createWinningLotto(getInput());
    }

    private static int getBonusNumber() {
        OutputView.printMsg(ASK_Bonus_NUMBERS);

        String input = getInput();

        if(!StringHandler.isNumeric(input)){
            OutputView.printMsg("숫자가 아닙니다.");
            return getBonusNumber();
        };

        return Integer.parseInt(input);
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}
