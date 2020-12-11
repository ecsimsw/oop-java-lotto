package view;

import domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class In {
    private In(){}

    public static Lotto getLastLotto(Scanner scanner){
        Out.print("작년 로또 번호를 입력하세요.\n");
        String line = In.getInput(scanner);
        List<Integer> numbers = Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    public static int getBonusNumber(Scanner scanner){
        Out.print("보너스 번호를 입력하세요. \n");
        return Integer.parseInt(In.getInput(scanner));
    }

    public static int getMoney(Scanner scanner){
        Out.print("로또 구입 금액을 입력해주세요.\n");
        try{
            return Integer.parseInt(getInput(scanner));
        }catch (Exception e){
            Out.print("숫자를 입력해주세요\n");
            return getMoney(scanner);
        }
    }

    public static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
