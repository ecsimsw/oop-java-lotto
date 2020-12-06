package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHandler {
    private StringHandler() {
    }

    public static List<Integer> parseIntegerList(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
