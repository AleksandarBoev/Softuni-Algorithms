package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P07PathsInLabyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(consoleReader.readLine());
        int cols = Integer.parseInt(consoleReader.readLine());

        char[][] labyrinth = new char[rows][cols];
        int endRow = -1;
        int endCol = -1;

        for (int i = 0; i < rows; i++) {
            String input = consoleReader.readLine();
            labyrinth[i] = input.toCharArray();

            if (endRow == -1) {
                int endIndex = input.indexOf('e');
                if (endIndex >= 0) {
                    endRow = i;
                    endCol = endIndex;
                }
            }
        }
        consoleReader.close();

        findPath(new LinkedList<>(), labyrinth, 0, 0);
    }

    private static void findPath(LinkedList<String> directions, char[][] labyrinth, int row, int col) {
        if (!correctPosition(row, col, labyrinth)) {
            directions.removeLast();
            return;
        }

        if (labyrinth[row][col] == 'e') {
            System.out.println(String.join("", directions));
            directions.removeLast();
            return;
        }

        labyrinth[row][col] = 'v'; // mark

        directions.add("R");
        findPath(directions, labyrinth, row, col + 1);

        directions.add("U");
        findPath(directions, labyrinth, row - 1, col);

        directions.add("L");
        findPath(directions, labyrinth, row, col - 1);

        directions.add("D");
        findPath(directions, labyrinth, row + 1, col);

        if (!directions.isEmpty()) { // unmark
            directions.removeLast();
            labyrinth[row][col] = '-';
        }
    }

    /*
    Needs to be inside the bounds of the labyrinth and also the coordinate must not hold a wall
    or been visited "v".
     */
    private static boolean correctPosition(int row, int col, char[][] labyrinth) {
        return row >= 0 && row < labyrinth.length
                && col >= 0 && col < labyrinth[0].length
                && (labyrinth[row][col] != '*' && labyrinth[row][col] != 'v');
    }
}
