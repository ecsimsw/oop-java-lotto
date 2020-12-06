import domain.*;

import view.InputView;

public class LottoGame {

    public LottoGame() {
    }

    public void play() {
        User user = User.purchaseLotto();
        user.printUserLottoList();

        WinningLotto winningLotto = InputView.getWinningLotto();
        user.printWinningResult(winningLotto);
        user.printEarningRate(winningLotto);
    }
}
