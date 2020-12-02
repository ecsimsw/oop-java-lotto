package lotto;

import java.util.List;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.Rank;
import lotto.lotto.WinningLotto;
import lotto.utils.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args){
        int purchaseAmount = InputView.getPurchaseAmount();
        int purchaseCount = Lotto.getNumberOfPurchase(purchaseAmount);
        OutputView.printNumberOfPurchase(purchaseCount);

        Lottos lottos = LottoFactory.createLottos(purchaseCount);
        lottos.printLottos();

        WinningLotto winningLotto = InputView.getWinningLotto();
        lottos.printPriceStatistics(winningLotto);

        lottos.printProfit(winningLotto, purchaseAmount);
    }
}
