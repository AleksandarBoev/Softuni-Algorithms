package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04Generating01Vectors {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int vectorLength = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();

        System.out.println(getAllVectors(vectorLength));
    }

    private static String getAllVectors(int vectorLength) {
        int[] vector = new int[vectorLength];

        for (int i = 0; i < vectorLength; i++) { // for easier understanding when debugging
            vector[i] = -1;
        }

        StringBuilder result = new StringBuilder();
        getAllVectors(vector, 0, result);
        return result.toString().trim();
    }

    /*
        Previous tasks reach the base case once and then start returning values.
    Here the base case needs to be reached multiple times to get all variations.
        Debug to better understand the algorithm.
     */
    private static void getAllVectors(int[] vector, int index, StringBuilder result) {
        if (index == vector.length) {
            result.append(getAsString(vector)).append(System.lineSeparator());
            return;
        }

        vector[index] = 0;
        getAllVectors(vector, index + 1, result);

        vector[index] = 1;
        getAllVectors(vector, index + 1, result); // all elements after current index changed to 0
    }

    private static String getAsString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
        }
        return new String(result);
    }
}
