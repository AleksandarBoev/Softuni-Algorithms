package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int factorialNumber = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();

        System.out.println(getFactorial(factorialNumber));
    }

    private static int getFactorial(int factorialNumber) {
        if (factorialNumber == 1) {
            return 1;
        }

        int factorialResultSoFar = getFactorial(factorialNumber - 1);
        return factorialResultSoFar * factorialNumber;
    }
}
