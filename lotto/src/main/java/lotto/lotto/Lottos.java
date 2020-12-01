package lotto.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List lottos){
        this.lottos = lottos;
    }

    public void printLottos(){
        lottos.stream().forEach(Lotto::printNumbers);
    }

    public int getPrizeMoney(WinningLotto winningLotto){
        int money = 0;
        for(Rank rank : getRank(winningLotto)){
            money += rank.getWinningMoney();
        }
        return money;
    }

    private List<Rank> getRank(WinningLotto winningLotto){
        return lottos.stream()
                .map(lotto-> winningLotto.match(lotto))
                .collect(Collectors.toList());
    }
}
