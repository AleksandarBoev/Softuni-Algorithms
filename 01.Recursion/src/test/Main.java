package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] set = new Integer[]{1, 2, 3, 4};
        Integer[] vector = new Integer[2];

        generateCombinations(set, vector, 0, 0);
    }

    private static void generateCombinations(Integer[] set, Integer[] vector,
                                             int index, int border) {
        if (index >= vector.length) {
            System.out.println(toString(" ", vector));
        } else {
            for (int i = border; i < set.length; i++) {
                vector[index] = set[i];
                generateCombinations(set, vector, index + 1, i + 1);
            }
        }
    }

    private static String toString(String delimiter, Integer[] array) {
        return String.join(delimiter,
                Arrays.stream(array)
                        .map(e -> e.toString())
                        .collect(Collectors.toList()));
    }
}
