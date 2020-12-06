package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void printLottoList() {
        lottoList.stream().forEach(l -> l.printNumbers());
    }

    public void printWinningResult(WinningLotto winningLotto) {
        int[] matchCounts = getMatchCounts(winningLotto);
        OutputView.printMatchScore(matchCounts);
    }

    private int[] getMatchCounts(WinningLotto winningLotto) {
        List<Rank> rankList = getRankList(winningLotto);
        int[] matchCounts = new int[Lotto.NUMBER_OF_NUMBERS];
        rankList.stream().forEach(rank -> matchCounts[rank.ordinal()]++);
        return matchCounts;
    }

    private List<Rank> getRankList(WinningLotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> lotto.calculateRank(winningLotto))
                .collect(Collectors.toList());
    }

    public int getTotalPrize(WinningLotto winningLotto) {
        List<Rank> rankList = getRankList(winningLotto);
        int totalPrize = 0;
        for(Rank rank : rankList){
            totalPrize += rank.getWinningMoney();
        }
        return totalPrize;
    }
}
