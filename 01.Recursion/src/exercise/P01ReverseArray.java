package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputTokens = consoleReader.readLine().split(" ");
        consoleReader.close();

        printRecursively(inputTokens);
    }

    private static void printRecursively(Object[] array) {
        printRecursively(array, 0);
    }

    private static void printRecursively(Object[] array, int index) {
        if (index == array.length) {
            return;
        }

        printRecursively(array, index + 1);
        System.out.print(array[index] + " ");
    }
}
