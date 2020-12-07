package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    public static final String DELIMITER_NAMES = ",";

    private List<Lotto> lottos;
    private Map<Rank, Integer> rankTable = new HashMap<>();

    private Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static Lottos buyLottos(int quantity){
        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < quantity){
            lottos.add(LottoFactory.createLotto());
        }
        return new Lottos(lottos);
    }

    public void printResult(WinningLotto winningLotto){
        setRankTable(winningLotto);
        OutputView.printResult(rankTable);
    }

    private void setRankTable(WinningLotto winningLotto){
        initializeRankTable();
        for(Rank rank : getRankList(winningLotto)){
            rankTable.put(rank, rankTable.get(rank)+1);
        }
        rankTable.remove(Rank.MISS);
    }

    private void initializeRankTable(){
        for(Rank rank : Rank.values()){
            rankTable.put(rank,0);
        }
    }

    private List<Rank> getRankList(WinningLotto winningLotto){
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningLotto))
                .collect(Collectors.toList());
    }

    public Money getPrize(WinningLotto winningLotto){
        List<Rank> ranks = getRankList(winningLotto);
        int totalPrize = 0;
        for(Rank rank : ranks){
            totalPrize += rank.getWinningMoney();
        }
        return new Money(totalPrize);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos){
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
