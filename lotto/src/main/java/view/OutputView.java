package view;

import domain.Rank;

import java.util.Map;

public class OutputView {
    private static final String MATCH_MESSAGE = "%s개 일치 (%s원) - %s개\n";
    private static final String SECOND_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (%s원) - %s개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s %%입니다.\n";
    private static final int PRINT_WINNING_FROM = 4;
    private static final int PRINT_WINNING_TO = 0;

    private OutputView() {
    }

    public static void printResult(Map<Rank, Integer> rankTable){
        for(Rank rank : Rank.values()){
            if(rank == Rank.MISS){
                continue;
            }

            if(rank != Rank.SECOND){
                int index = rank.ordinal();
                OutputView.printfMsg(MATCH_MESSAGE,
                        Rank.values()[index].getCountOfMatch(),
                        Rank.values()[index].getWinningMoney(),
                        rankTable.get(Rank.values()[index]));
                continue;
            }

            if(rank == Rank.SECOND){
                int index = rank.ordinal();
                OutputView.printfMsg(SECOND_MATCH_MESSAGE,
                        Rank.values()[index].getWinningMoney(),
                        rankTable.get(Rank.values()[index]));
                continue;
            }
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
