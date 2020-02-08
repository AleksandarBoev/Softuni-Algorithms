package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class P06ConnectedAreasInAMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        final int rows = Integer.parseInt(consoleReader.readLine());
        final int cols = Integer.parseInt(consoleReader.readLine());
        final char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = consoleReader.readLine().toCharArray();
        }

        consoleReader.close();

        MatrixAreas matrixAreas = new MatrixAreas(matrix);
        System.out.println(matrixAreas.getResults());
    }

    private static class MatrixAreas {
        private char[][] matrix;
        private TreeSet<Area> areas;

        public MatrixAreas(char[][] matrix) {
            this.matrix = getCopy(matrix);
            areas = new TreeSet<>();
            saveAreas();
        }

        public String getResults() {
            StringBuilder results = new StringBuilder();
            results.append("Total areas found: ").append(areas.size()).append(System.lineSeparator());

            int counter = 1;
            for (Area area : areas) {
                results.append(String.format("Area #%d at (%d, %d), size: %d%n", counter, area.startRow, area.startCol, area.size));
                counter++;
            }

            return results.toString().trim();
        }

        private char[][] getCopy(char[][] matrix) {
            char[][] newMatrix = new char[matrix.length][matrix[0].length];

            for (int row = 0; row < newMatrix.length; row ++) {
                newMatrix[row] = Arrays.copyOf(matrix[row], matrix[row].length);
            }

            return newMatrix;
        }

        private void saveAreas() {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == '-') {
                        Area newArea = new Area(row, col);
                        saveArea(row, col, newArea);
                        areas.add(newArea);
                    }
                }
            }
        }

        private void saveArea(int row, int col, Area area) {
            if (!areValidCoordinates(row, col)) {
                return;
            }

            area.incrementSize();
            matrix[row][col] = 'v';

            saveArea(row, col + 1, area); //right
            saveArea(row + 1, col, area); //down
            saveArea(row, col - 1, area); //left
            saveArea(row - 1, col, area); //up
        }

        private boolean areValidCoordinates(int row, int col) {
            return row >= 0 && row < matrix.length
                    && col >= 0 && col < matrix[0].length
                    && matrix[row][col] == '-'; // "v" is for visited. A way of marking
        }

        private static class Area implements Comparable<Area> {
            private int startRow;
            private int startCol;
            private int size;

            public Area(int startRow, int startCol) {
                this.startRow = startRow;
                this.startCol = startCol;
            }

            public void incrementSize() {
                size++;
            }

            @Override
            public int compareTo(Area otherArea) {
                int comparisonResult = Integer.compare(otherArea.size, this.size);

                if (comparisonResult == 0) {
                    comparisonResult = Integer.compare(this.startRow, otherArea.startRow);
                }

                if (comparisonResult == 0) {
                    comparisonResult = Integer.compare(this.startCol, otherArea.startCol);
                }

                return comparisonResult;
            }
        }
    }
}