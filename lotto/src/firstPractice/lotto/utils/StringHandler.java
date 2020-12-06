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

    public static List<Integer> toNumberList(String input) {
        String[] split = input.split(InputView.SEPARATOR_NUMBERS);
        InputValidator.checkAllNumeric(split);
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
