package view;

public class OutputView {
    private static final String MATCH_MESSAGE = "%s개 일치 (%s원) - %s개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s %%입니다.\n";

    private OutputView() {
    }

    public static void printMatchScore(int needToMatch, int winningMoney, int countOfMatch) {
        printfMsg(MATCH_MESSAGE, needToMatch, winningMoney, countOfMatch);
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
