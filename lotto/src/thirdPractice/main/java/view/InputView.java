package view;

import domain.Lotto;
import domain.Lottos;
import domain.Money;
import domain.WinningLotto;
import utils.StringHandler;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String ASK_WINNER_NUMBER = "지난 주 당첨 번호를 입력해주세요.\n";
    private static final String ASK_BONUS_BALL = "보너스 볼을 입력해주세요. \n";

    private InputView() {
    }

    public static Money getAmount(){
        try{
            OutputView.printMsg(ASK_MONEY_MESSAGE);
            return new Money(getInteger());
        }catch (Exception e){
            OutputView.printfMsg("적절하지 않은 금액");
            return getAmount();
        }
    }

    public static Lotto getLastLotto(){
        try{
            OutputView.printMsg(ASK_WINNER_NUMBER);
            List<Integer> list = StringHandler.parseIntegerList(getInput(), Lottos.DELIMITER_NAMES);
            return new Lotto(list);
        }catch (Exception e){
            OutputView.printMsg(e.getMessage());
            return getLastLotto();
        }
    }

    public static WinningLotto getBonus(Lotto lastLotto){
        try{
            OutputView.printMsg(ASK_BONUS_BALL);
            int bonus = getInteger();
            return new WinningLotto(lastLotto, bonus);
        }catch (Exception e){
            OutputView.printMsg(e.getMessage());
            return getBonus(lastLotto);
        }
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
