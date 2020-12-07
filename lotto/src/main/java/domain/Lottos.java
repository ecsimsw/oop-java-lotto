package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final String DELIMITER_NAMES = ",";
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static Lottos buyLottos(int quantity){
        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < quantity){
            lottos.add(LottoFactory.createLotto());
        }        return new Lottos(lottos);
    }

    private List<Rank> getRankList(WinningLott`o win`ningLotto){
        lottos.stream().map(lotto -> lotto.getCountOfMatch())
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
