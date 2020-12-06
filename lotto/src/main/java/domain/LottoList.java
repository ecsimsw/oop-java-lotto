package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private static final int PRINT_WINNING_FROM = 4;
    private static final int PRINT_WINNING_TO = 0;

    List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public void print(){
        lottoList.stream().forEach(l-> l.printNumbers());
    }

    public void printWinningResult(WinningLotto winningLotto){
        List<Rank> rankList = getRankList(winningLotto);
        int[] matchCounts = getMatchCountArray(rankList);
        for(int i = PRINT_WINNING_FROM; i>= PRINT_WINNING_TO; i--){
            int needToMatch = Rank.values()[i].getCountOfMatch();
            int winningMoney = Rank.values()[i].getWinningMoney();
            int matchCount = matchCounts[i];
            OutputView.printMatchScore(needToMatch, winningMoney, matchCount);
        }
    }

    private int[] getMatchCountArray(List<Rank> rankList){
        int[] matchCounts = new int[6];
        for(Rank rank : rankList){
            matchCounts[rank.ordinal()]++;
        }
        return matchCounts;
    }

    private List<Rank> getRankList(WinningLotto winningLotto){
        return lottoList.stream()
                .map(lotto -> lotto.calculateRank(winningLotto))
                .collect(Collectors.toList());
    }
}
