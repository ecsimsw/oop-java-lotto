package view;

import domain.Lotto;
import domain.Money;
import utils.StringHandler;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String ASK_WINNER_NUMBER = "지난 주 당첨 번호를 입력해주세요.\n";

    private InputView(){}

    public static Money getMoney(){
        try{
            OutputView.printMsg(ASK_MONEY_MESSAGE);
            return new Money(getInteger());
        }catch (IllegalArgumentException IAE){
            OutputView.printMsg(IAE.getMessage());
            return getMoney();
        }
    }

    public static Lotto getWinnerNumber(){
        try{
            OutputView.printMsg(ASK_WINNER_NUMBER);
            String line = getInput();
            return new Lotto(StringHandler.parseIntegerList(line, ","));
        }catch (IllegalArgumentException IAE){
            OutputView.printMsg(IAE.getMessage());
            return getWinnerNumber();
        }
    }

    private static int getInteger(){
        return Integer.parseInt(getInput());
    }

    private static String getInput(){
        return scanner.nextLine();
    }
}
