import domain.Lotto;
import domain.WinningLotto;
import utils.LottoFactory;
import view.In;
import view.Out;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int money = In.getMoney(scanner);

        int lottoCnt = money / Lotto.PRICE;
        int used = money - lottoCnt * Lotto.PRICE;

        List<Lotto> lottoList = LottoFactory.getLottoList(lottoCnt);

        Lotto lastLotto = In.getLastLotto(scanner);
        int bonus = In.getBonusNumber(scanner);
        createWinningLotto(lastLotto, bonus);

    }



    public static WinningLotto createWinningLotto(Lotto lotto, int bonus){
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        // bonus 숫자 범위
        // bonus가 lotto에 포함되진 않는지 체크
        return winningLotto;
    }


}
