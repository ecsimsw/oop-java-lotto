package lotto.lotto;

import java.util.List;

public class Lottos {
    public List<Lotto> lottos;

    public Lottos(List lottos){
        this.lottos = lottos;
    }

    public void printLottos(){
        lottos.stream().forEach(Lotto::printNumbers);
    }
}
