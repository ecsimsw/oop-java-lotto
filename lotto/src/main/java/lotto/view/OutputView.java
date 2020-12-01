package lotto.view;

import lotto.lotto.Lotto;

public class OutputView {
    private static final String NUMBER_OF_PURCHASE = "개 구매하였습니다. \n";

    private OutputView(){}

    public static void printNumberOfPurchase(int purchaseAmount) {
        printMsg(Lotto.getNumberOfPurchase(purchaseAmount));
        printMsg(NUMBER_OF_PURCHASE);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
