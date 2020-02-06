package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int drawingSize = Integer.parseInt(consoleReader.readLine());
        consoleReader.close();

        System.out.println(getDrawing(drawingSize));
    }

    private static String getDrawing(int drawingSize) {
        StringBuilder result = new StringBuilder();
        getDrawing(drawingSize, result);
        return result.toString().trim();
    }

    private static void getDrawing(int drawingSize, StringBuilder result) {
        if (drawingSize == 0) { // base case
            return;
        }

        //Pre Actions
        result.append(buildString('*', drawingSize)).append(System.lineSeparator());

        //Recursive calls
        getDrawing(drawingSize - 1, result);

        //Post Actions
        result.append(buildString('#', drawingSize)).append(System.lineSeparator());
    }

    private static String buildString(Character character, int length) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(character);
        }

        return new String(result);
    }
}
