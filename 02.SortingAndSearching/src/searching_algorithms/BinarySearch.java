package searching_algorithms;

public class BinarySearch {
    //TODO try making a recursive variant.
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
