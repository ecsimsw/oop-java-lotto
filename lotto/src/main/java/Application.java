import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import utils.LottoFactory;
import view.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int money = In.getMoney(scanner);

        int lottoCnt = money / Lotto.PRICE;
        int used = money - lottoCnt * Lotto.PRICE;

        List<Lotto> lottoList = LottoFactory.getLottoList(lottoCnt);

        Lotto lastLotto = In.getLastLotto(scanner);
        int bonus = In.getBonusNumber(scanner);
        WinningLotto winningLotto = WinningLotto.create(lastLotto, bonus);

        List<Rank> ranks = new ArrayList<>();
        for(Lotto lotto : lottoList){
            ranks.add(winningLotto.match(lotto));
        }

        int prize =0;
        for(Rank rank : ranks){
            prize += rank.getWinningMoney();
        }

        int rate = (int)(prize / (double)used * 100);
        System.out.print(rate);
    }
}
