package lotto.utils;

import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {

    private StringHandler(){}

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (IllegalArgumentException IAE) {
            return false;
        }
    }

    public static List<Integer> toNumberList(String input){
        InputValidator.checkAllNumeric(input);
        return Arrays.stream(input.split(InputView.SEPARATOR_NUMBERS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
