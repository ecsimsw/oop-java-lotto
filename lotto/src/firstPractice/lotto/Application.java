package lotto;

import lotto.lotto.Buyer;
import lotto.lotto.WinningLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        WinningLotto winningLotto = InputView.getWinningLotto();

        buyer.printResult(winningLotto);
    }
}
