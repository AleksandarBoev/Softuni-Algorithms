package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05GeneratingCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(consoleReader.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();
        int k = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();

        System.out.println(getAllCombinations(numbers, k));
    }

    private static String getAllCombinations(int[] numbers, int k) {
        int[] combination = new int[k];
        StringBuilder result = new StringBuilder();
        getAllCombinations(numbers, combination, 0, 0, result);
        return new String(result);
    }

    /*
        Base case is reached multiple times again. But the recursive call this time is made with only one different parameter
    most of the time (leftBorder). And other times with 2 different parameters (indexToChange)
     */
    private static void getAllCombinations(int[] numbers, int[] combination, int indexToChange, int leftBorder, StringBuilder result) {
        if (indexToChange >= combination.length) {
            result.append(getAsString(combination)).append(System.lineSeparator());
            return;
        }

        for (int i = leftBorder; i < numbers.length; i++) {
            combination[indexToChange] = numbers[i];
            getAllCombinations(numbers, combination, indexToChange + 1, i + 1, result);
        }
    }

    private static String getAsString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]).append(" ");
        }
        return new String(result);
    }
}
