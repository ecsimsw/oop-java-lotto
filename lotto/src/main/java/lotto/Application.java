package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.utils.LottoFactory;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args){
        int purchaseAmount = InputView.getPurchaseAmount();
        int purchaseCount = Lotto.getNumberOfPurchase(purchaseAmount);

        Lottos lottos = LottoFactory.createLottos(purchaseCount);
        lottos.printLottos();
    }
}
