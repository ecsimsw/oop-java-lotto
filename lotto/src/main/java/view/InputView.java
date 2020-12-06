package view;

import domain.Lotto;
import domain.Money;
import domain.WinningLotto;
import utils.StringHandler;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String ASK_WINNER_NUMBER = "지난 주 당첨 번호를 입력해주세요.\n";
    private static final String ASK_BONUS_BALL = "보너스 볼을 입력해주세요. \n";

    private InputView() {
    }

    public static Money getMoney() {
        try {
            OutputView.printMsg(ASK_MONEY_MESSAGE);
            return new Money(getInteger());
        } catch (IllegalArgumentException IAE) {
            OutputView.printMsg(IAE.getMessage());
            return getMoney();
        }
    }

    public static WinningLotto getWinningLotto() {
        Lotto lotto = getLastLotto();
        try {
            int bonus = getBonusBall();
            return new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException IAE) {
            OutputView.printMsg(IAE.getMessage());
            return new WinningLotto(lotto, getBonusBall());
        }
    }

    private static WinningLotto getWinningLotto(Lotto lotto) {
        try {
            int bonus = getBonusBall();
            return new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException IAE) {
            OutputView.printMsg(IAE.getMessage());
            return new WinningLotto(lotto, getBonusBall());
        }
    }

    private static Lotto getLastLotto() {
        try {
            OutputView.printMsg(ASK_WINNER_NUMBER);
            String line = getInput();
            return new Lotto(StringHandler.parseIntegerList(line, ","));
        } catch (IllegalArgumentException IAE) {
            OutputView.printMsg(IAE.getMessage());
            return getLastLotto();
        }
    }

    public static int getBonusBall() {
        OutputView.printMsg(ASK_BONUS_BALL);
        return getInteger();
    }

    private static int getInteger() {
        try {
            return Integer.parseInt(getInput());
        } catch (NumberFormatException NFE) {
            OutputView.printMsg("숫자를 입력하시오.\n");
            return getInteger();
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}
