import domain.*;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;

public class LottoController {

    public LottoController() {
    }

    public void play() {
        Money userAmount = InputView.getAmount();
        int quantity = Money.getAvailableQuantity(Lotto.price, userAmount);

        Lottos userLottos = Lottos.buyLottos(quantity);
        OutputView.printMsg(userLottos.toString());

        Lotto lastLotto = InputView.getLastLotto();
        WinningLotto winningLotto = InputView.getBonus(lastLotto);

        userLottos.printResult(winningLotto);

        Money earned = userLottos.getPrize(winningLotto);
        Money used = Money.getUsedAmount(Lotto.price, userAmount);

        OutputView.printEarningRate(Money.getEarningRate(used, earned));
    }
}
