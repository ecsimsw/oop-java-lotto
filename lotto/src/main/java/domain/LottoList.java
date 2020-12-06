package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private static final int PRINT_WINNING_FROM = 4;
    private static final int PRINT_WINNING_TO = 0;

    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void printLottoList() {
        lottoList.stream().forEach(l -> l.printNumbers());
    }

    public void printWinningResult(WinningLotto winningLotto) {
        int[] matchCounts = getMatchCounts(winningLotto);
        for (int i = PRINT_WINNING_FROM; i >= PRINT_WINNING_TO; i--) {
            int needToMatch = Rank.values()[i].getCountOfMatch();
            int winningMoney = Rank.values()[i].getWinningMoney();
            OutputView.printMatchScore(needToMatch, winningMoney, matchCounts[i]);
        }
    }

    private int[] getMatchCounts(WinningLotto winningLotto) {
        List<Rank> rankList = getRankList(winningLotto);
        int[] matchCounts = new int[Lotto.NUMBER_OF_NUMBERS];
        for (Rank rank : rankList) {
            matchCounts[rank.ordinal()]++;
        }
        return matchCounts;
    }

    private List<Rank> getRankList(WinningLotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> lotto.calculateRank(winningLotto))
                .collect(Collectors.toList());
    }

    public int getTotalPrize(WinningLotto winningLotto) {
        int[] matchCounts = getMatchCounts(winningLotto);
        int totalPrize = 0;
        int rankValuesSize = Rank.values().length;
        for (int i = 0; i < rankValuesSize; i++) {
            int winningMoney = Rank.values()[i].getWinningMoney();
            totalPrize += (winningMoney * matchCounts[i]);
        }
        return totalPrize;
    }
}
