package lotto.lotto;

import lotto.utils.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Buyer {
    private final int purchaseAmount;
    private final int purchaseCount;
    private Lottos lottos;

    public Buyer() {
        purchaseAmount = InputView.getPurchaseAmount();
        purchaseCount = Lotto.getNumberOfPurchase(purchaseAmount);
        printPurchaseCount();

        createUserLottos();
        printUserLottos();
    }

    private void printPurchaseCount() {
        OutputView.printNumberOfPurchase(purchaseCount);
    }

    private void createUserLottos() {
        lottos = LottoFactory.createLottos(purchaseCount);
    }

    private void printUserLottos() {
        lottos.printLottos();
    }

    public void printResult(WinningLotto winningLotto) {
        lottos.printPriceStatistics(winningLotto);
        lottos.printProfit(winningLotto, purchaseAmount);
    }
}
