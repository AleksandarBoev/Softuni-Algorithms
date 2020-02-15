import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSortImpl {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 8, 5, 3, 9, 4, 1, 7};
//        Integer[] array = new Integer[]{2, 8, 5, 3, 9, 4, 1};

        System.out.println("Before sort: " + String.join(" | ", Arrays.stream(array).map(e -> e + "").collect(Collectors.toList())));

        sort(array);
        System.out.println("After sort:  " + String.join(" | ", Arrays.stream(array).map(e -> e + "").collect(Collectors.toList())));
    }

    private static void sort(Integer[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Integer[] array, int left, int right) {
        if (right <= left) {
            return;
        }

        int partitionElementIndex = partition(array, left, right);
        sort(array, left, partitionElementIndex - 1); // sort left half of current partition
        sort(array, partitionElementIndex + 1, right); // sort right half of current partition
    }

    private static int partition(Integer[] array, int left, int right) {
        int leftScanIndex = left;
        int rightScanIndex = right + 1;

        Integer partitionElement = array[left];

        while (true) {
            //after this while cycle "leftScanIndex" is the index of an element which is BIGGER than partition element
            //moves from left to right until it reaches a bigger element than partition element
            while (array[++leftScanIndex].compareTo(partitionElement) < 0) { // element is smaller than partition
                if (leftScanIndex == right) {
                    break;
                }
            }

            //after this while cycle "rightScanIndex" is the index of an element which is SMALLER than partition element
            //moves from right to left until it reaches a smaller element than partition element
            while (array[--rightScanIndex].compareTo(partitionElement) > 0) { // element is bigger than partition
                if (rightScanIndex == left) {
                    break;
                }
            }

            if (leftScanIndex >= rightScanIndex) {
                break;
            }

            //swap element at "leftScanIndex" (bigger than partition) with element at "rightScanIndex" (smaller than partition)
            //Result is that on the left will be the smaller element and on the right - the bigger element.
            Integer temp = array[leftScanIndex];
            array[leftScanIndex] = array[rightScanIndex];
            array[rightScanIndex] = temp;
        }

        //at "rightScanIndex" is an element, smaller than partition
        //slap partition element with the smaller one
        Integer temp = array[left];
        array[left] = array[rightScanIndex];
        array[rightScanIndex] = temp;

        return rightScanIndex;
    }
}
