package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchase() {
        OutputView.printMsg(ASK_PURCHASE_AMOUNT);
        try {
            return Integer.parseInt(getInput());
        } catch (IllegalArgumentException IAE) {
            IAE.printStackTrace();
            return getPurchase();
        }
    }

    private static String getInput() {
        return scanner.nextLine();
    }
}
