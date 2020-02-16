package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(consoleReader.readLine().split(" ")).map(Integer::parseInt).toArray(n -> new Integer[n]);
        consoleReader.close();

        MergeSort.sort(numbers);
        System.out.println(getArrayAsString(numbers, " "));
    }

    public static class MergeSort {
        private static Integer[] secondArray;

        public static void sort(Integer[] array) {
//            secondArray = new Integer[array.length];
            sort(array, 0, array.length - 1);
        }

        //recursively breaks down the array into smaller parts. Well, it doesn't exactly break it down, just works with
        //the indices, which will be used to create smaller arrays and do the merge sort.
        private static void sort(Integer[] array, int low, int high) {
            if (low >= high) {
                return;
            }

            int mid = low + (high - low) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            sort(array, low, mid, high); // make 2 arrays with given indices and merge sort them into the original
        }

        private static void sort(Integer[] array, int low, int mid, int high) {
            // Last element of future firstArray and first element of future secondArray. Both arrays are sorted.
            // So if the last element of the first one is smaller than the first of the second array
            // --> that means the elements together are sorted and the merge sort is not needed.
            if (Integer.compare(array[mid], array[mid + 1]) < 0) {
                return;
            }

            int firstArraySize = mid - low + 1;
            int secondArraySize = high - mid;

            // Memory inefficient using arrays, but easier to understand and visualize while debugging
            // Note: the first small array and second small array are both separately sorted! Always!
            Integer[] firstSortedArray = Arrays.copyOfRange(array, low, mid + 1); // second int param is exclusive in this method
            Integer[] secondSortedArray = Arrays.copyOfRange(array, mid + 1, high + 1);

            int firstArrayIndexCounter = 0;
            int secondArrayIndexCounter = 0;

            //Assigning new values to original array using the two arrays.
            for (int k = low; k <= high; k++) { // "k" will be used as index iterator to only to assign values to ORIGINAL array

                if (firstArrayIndexCounter >= firstArraySize) {  // a.k.a. first array is used up. What's left to do is assign all elements from second array.
                    array[k] = secondSortedArray[secondArrayIndexCounter];
                    secondArrayIndexCounter++;
                } else if (secondArrayIndexCounter >= secondArraySize) { // same as the above condition, but reversed
                    array[k] = firstSortedArray[firstArrayIndexCounter];
                    firstArrayIndexCounter++;
                } else if (Integer.compare(firstSortedArray[firstArrayIndexCounter], secondSortedArray[secondArrayIndexCounter]) <= 0) {
                    // if element from first small array is smaller/equal. This makes the sorting algorithm stable
                    array[k] = firstSortedArray[firstArrayIndexCounter];
                    firstArrayIndexCounter++;
                } else { // if element from second small array is smaller or equal
                    array[k] = secondSortedArray[secondArrayIndexCounter];
                    secondArrayIndexCounter++;
                }
            }
        }
    }

    /*
Optimal version without additional arrays:

private static void sort(Integer[] array, int low, int mid, int high) {
            if (Integer.compare(array[mid], array[mid + 1]) < 0) {
                return;
            }

            //Assign all elements from index low to index high from original array to secondary array
            //Second array's purpose is to serve like the split up arrays of the original one.
            //But instead of using two different small arrays to change up the original one,
            //the secondary array is used. More precisely from low to mid (that's the first small array)
            //and from mid + 1 to high (that's the second small array).
            //Note: the first small array and second small array are both separately sorted!
            for (int index = low; index <= high; index++) {
                secondArray[index] = array[index];
            }

            int beforeMiddleIndex = low;
            int afterMiddleIndex = mid + 1;

            for (int k = low; k <= high; k++) { // "k" will be used as index iterator to only to assign values to ORIGINAL array
                if (beforeMiddleIndex > mid) { // a.k.a. "beforeMiddleIndex" has been incremented so much, that it is past the middle. That means all elements before the middle are assigned and what's left to do is assign all elements AFTER the middle. Elements in both arrays are sorted so no need fo checks.
                    array[k] = secondArray[afterMiddleIndex];
                    afterMiddleIndex++;
                } else if (afterMiddleIndex > high) { // same as the above condition. All "afterMiddleIndex" have been assigned and what's left is the other half.
                    array[k] = secondArray[beforeMiddleIndex];
                    beforeMiddleIndex++;
                } else if (Integer.compare(secondArray[beforeMiddleIndex], secondArray[afterMiddleIndex]) < 0) {
                    array[k] = secondArray[beforeMiddleIndex];
                    beforeMiddleIndex++;
                } else {
                    array[k] = secondArray[afterMiddleIndex];
                    afterMiddleIndex++;
                }
            }
        }
    }
 */

    private static String getArrayAsString(Integer[] array, String delimiter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]).append(delimiter);
        }

        return result.substring(0, result.length() - delimiter.length());
    }
}
