package view;

import domain.Rank;

public class OutputView {
    private static final String MATCH_MESSAGE = "%s개 일치 (%s원) - %s개\n";
    private static final String SECOND_CONDITION = "5개 일치, 보너스 볼 일치\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s %%입니다.\n";
    private static final int PRINT_WINNING_FROM = 4;
    private static final int PRINT_WINNING_TO = 0;

    private OutputView() {
    }

    public static void printMatchScore(int[] matchCounts) {
        for (int i = PRINT_WINNING_FROM; i >= PRINT_WINNING_TO; i--) {
            int condition = Rank.values()[i].getCountOfMatch();
            int winningMoney = Rank.values()[i].getWinningMoney();

            if(Rank.values()[i] == Rank.SECOND){
                printfMsg(MATCH_MESSAGE, SECOND_CONDITION, winningMoney, matchCounts[i]);
                return;
            }

            printfMsg(MATCH_MESSAGE, condition, winningMoney, matchCounts[i]);
        }
    }

    public static void printEarningRate(int earningRate) {
        printfMsg(EARNING_RATE_MESSAGE, earningRate);
    }

    public static void printfMsg(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public static void printMsg(Object msg) {
        System.out.print(msg);
    }
}
