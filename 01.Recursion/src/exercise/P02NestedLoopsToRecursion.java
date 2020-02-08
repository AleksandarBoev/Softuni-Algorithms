package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02NestedLoopsToRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();

        printNumbers(n);
    }

    private static void printNumbers(int n) {
        int[] vector = new int[n];

        printNumbers(vector, 0);
    }

    private static void printNumbers(int[] vector, int index) {
        if (index == vector.length) {
            System.out.println(getVectorAsString(vector));
            return;
        }

        for (int i = 1; i <= vector.length; i++) {
            vector[index] = i;
            printNumbers(vector, index + 1);
        }
    }

    private static String getVectorAsString(int[] vector) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vector.length; i++) {
            result.append(vector[i]).append(" ");
        }

        return result.toString().trim();
    }
}
