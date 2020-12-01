package lotto;

import java.util.List;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.Rank;
import lotto.lotto.WinningLotto;
import lotto.utils.LottoFactory;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args){
        int purchaseAmount = InputView.getPurchaseAmount();
        int purchaseCount = Lotto.getNumberOfPurchase(purchaseAmount);

        Lottos lottos = LottoFactory.createLottos(purchaseCount);
        lottos.printLottos();

        WinningLotto winningLotto = InputView.getWinningLotto();
        int prizeMoney = lottos.getPrizeMoney(winningLotto);

        
    }
}
