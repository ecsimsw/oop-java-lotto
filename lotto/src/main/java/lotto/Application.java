package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args){
        int purchaseAmount = InputView.getPurchaseAmount();
        OutputView.printNumberOfPurchase(purchaseAmount);
    }
}
