package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05CombinationsWithoutRepetition {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(consoleReader.readLine());
        int k = Integer.parseInt(consoleReader.readLine());

        consoleReader.close();

        printCombinationsWithoutRepetitions(n, k); // n = 3, k = 2
    }

    private static void printCombinationsWithoutRepetitions(int n, int k) {
        int[] vector = new int[k];

        printCombinationsWithoutRepetition(0, 1, n, vector);
    }

    private static void printCombinationsWithoutRepetition(int index, int value, int n, int[] vector) {
        if (index >= vector.length) {
            System.out.println(getVectorAsString(vector));
            return;
        }

        for (int i = value; i <= n; i++) {
            vector[index] = i;
            printCombinationsWithoutRepetition(index + 1, i + 1, n, vector);
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
