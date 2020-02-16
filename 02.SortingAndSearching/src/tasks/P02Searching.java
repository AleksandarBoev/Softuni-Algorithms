package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02Searching {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(consoleReader.readLine().split(" ")).map(Integer::parseInt).toArray(n -> new Integer[n]);

        System.out.println(BinarySearch.getElementIndex(Integer.parseInt(consoleReader.readLine()), numbers));
        consoleReader.close();
    }

    public static class BinarySearch {
        /**
         * @param array needs to be a sorted array
         */
        public static <T extends Comparable<T>> int getElementIndex(T element, T[] array) {
            int startIndex = 0;
            int endIndex = array.length;
            int lastMiddleIndexValue = -1;

            while (true) {
                int middleIndex = (endIndex + startIndex) / 2;

                if (middleIndex == lastMiddleIndexValue) {
                    return -1;
                }

                lastMiddleIndexValue = middleIndex;
                int comparisonResult = element.compareTo(array[middleIndex]);

                if (comparisonResult == 0) {
                    return middleIndex;
                } else if (comparisonResult < 0) { //search in the left half
                    endIndex = middleIndex;
                } else { //search in the right half
                    startIndex = middleIndex;
                }
            }
        }
    }

}
