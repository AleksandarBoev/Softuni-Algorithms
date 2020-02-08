package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03CombinationsWithRepetition {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(consoleReader.readLine());
        int k = Integer.parseInt(consoleReader.readLine());

        consoleReader.close();

        printCombinationsWithRepetition(n, k); // n = 3, k = 2
    }

    private static void printCombinationsWithRepetition(int n, int k) {
        int[] vector = new int[k];

//        printPermutationsWithRepetition(0, n, vector);
        printCombinationsWithRepetition(0, 1, n, vector);
    }

    private static void printCombinationsWithRepetition(int index, int value, int n, int[] vector) {
        if (index >= vector.length) {
            System.out.println(getVectorAsString(vector));
            return;
        }

        for (int i = value; i <= n; i++) {
            vector[index] = i;
            printCombinationsWithRepetition(index + 1, i, n, vector);
        }
    }

    /*
    Didn't read the task description correctly, but this look like it could be useful... I think
     */
    private static void printPermutationsWithRepetition(int index, int n, int[] vector) {
        if (index >= vector.length) {
            System.out.println(getVectorAsString(vector));
            return;
        }

        for (int i = 1; i <= n; i++) {
            vector[index] = i;
            printPermutationsWithRepetition(index + 1, n, vector);
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
