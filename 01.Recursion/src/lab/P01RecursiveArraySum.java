package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01RecursiveArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] inputNumbers = Arrays.stream(consoleReader.readLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .toArray(n -> new Integer[n]);

        consoleReader.close();

        System.out.println(getArraySum(inputNumbers));
    }

    private static int getArraySum(Integer[] array) {
        return getArraySum(array, 0);
    }

    private static int getArraySum(Integer[] array, int index) {
        if (index == array.length - 1) {
            return array[array.length - 1];
        }

        int sumSoFar = getArraySum(array, index + 1);
        return sumSoFar + array[index];
    }
}
