package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Just a quick second solution without the use of recursion.
 */
public class P04Generating01VectorsSolution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int vectorLength = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();

        printAllBinaries(vectorLength);
    }

    private static void printAllBinaries(int vectorLength) {
        int maxValue = (int) Math.pow(2, vectorLength);
        int maxLength = Integer.toBinaryString(maxValue - 1).length();

        for (int i = 0; i < maxValue; i++) {
            System.out.println(getStringWithTrailingZeros(Integer.toBinaryString(i), maxLength));
        }
    }

    private static String getStringWithTrailingZeros(String string, int lengthWanted) {
        StringBuilder result = new StringBuilder();

        for (int i = string.length(); i < lengthWanted; i++) {
            result.append("0");
        }

        result.append(string);
        return new String(result);
    }
}
