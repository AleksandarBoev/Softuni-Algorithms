package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03InversionCount {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(consoleReader.readLine().split(" ")).map(Integer::parseInt).toArray(n -> new Integer[n]);
        consoleReader.close();

        int inversionCounter = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    inversionCounter++;
                }
            }
        }

        System.out.println(inversionCounter);
    }
}
