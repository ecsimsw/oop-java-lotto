package view;

import java.util.Scanner;

public class In {
    public static int getMoney(Scanner scanner){
        Out.print("로또 구입 금액을 입력해주세요.\n");
        try{
            return Integer.parseInt(getInput(scanner));
        }catch (Exception e){
            Out.print("숫자를 입력해주세요\n");
            return getMoney(scanner);
        }
    }

    private static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
