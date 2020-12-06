package domain;

import java.util.List;

public class LottoList {

    List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public void print(){
        lottoList.stream().forEach(l-> l.printNumbers());
    }
}
