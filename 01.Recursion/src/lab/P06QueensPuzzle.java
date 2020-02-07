package lab;

import java.util.*;

public class P06QueensPuzzle {
    public static void main(String[] args) {
        QueensChessBoard queensChessBoard = new QueensChessBoard();
        for (String combination : queensChessBoard.getAllChessBoardCombinationsWithQueens()) {
            System.out.println(combination);
        }
    }

    private static class QueensChessBoard {
        private HashSet<Integer> attackedRows;
        private HashSet<Integer> attackedCols;
        private HashSet<Integer> attackedLeftDiagonals;
        private HashSet<Integer> attackedRightDiagonals;
        private char[][] chessBoard;

        public QueensChessBoard() {
            attackedRows = new HashSet<>(8);
            attackedCols = new HashSet<>(8);
            attackedLeftDiagonals = new HashSet<>(16);
            attackedRightDiagonals = new HashSet<>(16);

            chessBoard = new char[8][8];

            for (int row = 0; row < chessBoard.length; row++) {
                for (int col = 0; col < chessBoard[0].length; col++) {
                    chessBoard[row][col] = '-';
                }
            }
        }

        public Iterable<String> getAllChessBoardCombinationsWithQueens() {
            ArrayList<String> result = new ArrayList<>(92);

            getAllChessBoardCombinationsWithQueens(0, result);

            return result;
        }

        private void getAllChessBoardCombinationsWithQueens(int row, ArrayList<String> result) {
            if (row == 8) { // base case - rows from 0 to 7 are filled with queens --> adding correct result
                result.add(getChessBoardAsString());
                return;
            }

            for (int col = 0; col < 8; col++) {
                if (coordinatesAreSafe(row, col)) {
                    placeQueen(row, col);
                    getAllChessBoardCombinationsWithQueens(row + 1, result);
                    removeQueen(row, col);
                }
            }
        }

        private boolean coordinatesAreSafe(int row, int col) {
            return !attackedRows.contains(row)
                    && !attackedCols.contains(col)
                    && !attackedLeftDiagonals.contains(calculateLeftDiagonal(row, col))
                    && !attackedRightDiagonals.contains(calculateRightDiagonal(row, col));
        }

        private int calculateLeftDiagonal(int row, int col) {
            return col - row;
        }

        private int calculateRightDiagonal(int row, int col) {
            return col + row;
        }

        /*
        How "attackedLeftDiagonals" works:
        Values can be between -7 and 7.
        Example: Queen is placed on (5, 1). col - row = 1 - 5 = -4.
        Player wants to place new Queen on (7, 3). col - row = 3 - 7 = -4.

        How "attackedRightDiagonals" works:
        Values can be between 0 and 14.
        Example: Queen is placed on (5, 1). col + row = 1 + 5 = 6.
        Player wants to place new Queen on (2, 4). col + row = 2 + 4 = 6.
         */
        private void markAttackedPositions(int row, int col) {
            attackedRows.add(row);
            attackedCols.add(col);
            attackedLeftDiagonals.add(calculateLeftDiagonal(row, col));
            attackedRightDiagonals.add(calculateRightDiagonal(row, col));
        }


        private void unmarkAttackedPositions(int row, int col) {
            attackedRows.remove(row);
            attackedCols.remove(col);
            attackedLeftDiagonals.remove(calculateLeftDiagonal(row, col));
            attackedRightDiagonals.remove(calculateRightDiagonal(row, col));
        }

        private void placeQueen(int row, int col) {
            markAttackedPositions(row, col);
            chessBoard[row][col] = '*';
        }

        private void removeQueen(int row, int col) {
            unmarkAttackedPositions(row, col);
            chessBoard[row][col] = '-';
        }

        private String getChessBoardAsString() {
            StringBuilder result = new StringBuilder();

            for (int row = 0; row < chessBoard.length; row++) {
                for (int col = 0; col < chessBoard[0].length; col++) {
                    result.append(chessBoard[row][col]).append(" ");
                }

                result.append(System.lineSeparator());
            }

            return result.substring(0, result.length()); // crop out just the new line
        }
    }
}
