package lotto.view;

import lotto.lotto.Rank;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "%s개 구매하였습니다. \n";
    private static final String WINNING_COUNT_LINE = "%s개 일치 (%s원) - %s개\n";
    private static final String PROFIT_LINE_START = "총 수익률은 %s%%입니다.";

    private OutputView(){}

    public static void printNumbers(String numbers) {
        printMsg(numbers);
        printNewLine();
    }

    public static void printNewLine() {
        printMsg("\n");
    }

    public static void printNumberOfPurchase(int purchaseCount) {
        printfMsg(NUMBER_OF_PURCHASE, purchaseCount);
    }

    public static void printWinningLine(int index, int matchCount) {
        printfMsg(WINNING_COUNT_LINE,
                Rank.values()[index].getCountOfMatch(),
                Rank.values()[index].getWinningMoney(),
                matchCount);
    }

    public static void printProfit(int profit) {
        printfMsg(PROFIT_LINE_START, profit);
    }

    private static void printfMsg(String msg, Object... objects) {
        System.out.printf(msg, objects);
    }

    public static void printMsg(Object msg) {
        System.out.print(msg);
    }
}
