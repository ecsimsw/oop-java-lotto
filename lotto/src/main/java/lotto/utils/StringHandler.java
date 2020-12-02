package lotto.utils;

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
}
