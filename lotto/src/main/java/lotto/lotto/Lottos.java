package lotto.lotto;

import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private static final int PRINT_PRICE_FROM = 4;
    private static final int PRINT_PRICE_TO = 0;

    private final List<Lotto> lottos;

    public Lottos(List lottos) {
        this.lottos = lottos;
    }

    public void printLottos() {
        lottos.stream().forEach(Lotto::printNumbers);
    }

    public void printPriceStatistics(WinningLotto winningLotto) {
        List<Rank> rankList = getRankList(winningLotto);
        int[] winningCount = getWinningCountList(rankList);

        for (int i = PRINT_PRICE_FROM; i>= PRINT_PRICE_TO; i--) {
            OutputView.printWinningLine(i, winningCount[i]);
        }
    }

    private int[] getWinningCountList(List<Rank> rankList) {
        int[] winningCount = new int[Rank.values().length];

        for (int i=0; i<rankList.size(); i++) {
            Rank rank = rankList.get(i);
            winningCount[rank.ordinal()]++;
        }

        return winningCount;
    }

    public void printProfit(WinningLotto winningLotto, int originMoney) {
        int prizeMoney = getTotalPrize(winningLotto);
        int profit = (int)((prizeMoney/(double)originMoney)*100);

        OutputView.printProfit(profit);
    }

    private int getTotalPrize(WinningLotto winningLotto) {
        List<Rank> rankList = getRankList(winningLotto);

        int money = 0;
        for (Rank rank : rankList) {
            money += rank.getWinningMoney();
        }
        return money;
    }

    private List<Rank> getRankList(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto-> winningLotto.match(lotto))
                .collect(Collectors.toList());
    }
}
