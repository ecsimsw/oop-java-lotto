package view;

import domain.Money;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";

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

    private static int getInteger(){
        return Integer.parseInt(getInput());
    }

    private static String getInput(){
        return scanner.nextLine();
    }
}
