package domain;

import view.InputView;
import view.OutputView;

public class User {
    private final LottoList lottoList;
    private final Money usedMoney;

    private User(){
        Money userAmount = InputView.getMoney();
        int lottoCount = Lotto.getAvailableCountWith(userAmount);
        usedMoney = Lotto.getUsedMoney(userAmount);
        this.lottoList = LottoFactory.getLottoList(lottoCount);;
    }

    public static User purchaseLotto(){
        return new User();
    }

    public void printUserLottoList(){
        lottoList.printLottoList();
    }

    public void printWinningResult(WinningLotto winningLotto){
        lottoList.printWinningResult(winningLotto);
    }

    public void printEarningRate(WinningLotto winningLotto){
        Money prize = getTotalPrize(winningLotto);
        int earningRate = Money.getEarningRate(usedMoney, prize);
        OutputView.printEarningRate(earningRate);
    }

    private Money getTotalPrize(WinningLotto winningLotto){
        return new Money(lottoList.getTotalPrize(winningLotto));
    }
}
