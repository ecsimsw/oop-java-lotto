package lotto.view;

import lotto.lotto.Lotto;
import lotto.lotto.Rank;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "개 구매하였습니다. \n";
    private static final String WINNING_COUNT_LINE = "%s개 일치 (%s원) - %s개\n";
    private static final String PROFIT_LINE_START = "총 수익률은 ";
    private static final String PROFIT_LINE_END = "%입니다.";
    private OutputView(){}

    public static void printNumberOfPurchase(int purchaseAmount) {
        printMsg(Lotto.getNumberOfPurchase(purchaseAmount));
        printMsg(NUMBER_OF_PURCHASE);
    }

    public static void printWinningLine(int index, int matchCount){
        printfMsg(WINNING_COUNT_LINE,
                Rank.values()[index].getCountOfMatch(),
                Rank.values()[index].getWinningMoney(),
                matchCount);
    }

    public static void printProfit(int profit){
        printMsg(PROFIT_LINE_START);
        printMsg(profit);
        printMsg(PROFIT_LINE_END);
    }

    private static void printfMsg(String msg, Object... objects){
        System.out.printf(msg, objects);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
