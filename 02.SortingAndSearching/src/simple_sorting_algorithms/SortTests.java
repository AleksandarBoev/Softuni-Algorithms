package simple_sorting_algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortTests {
    Integer[][] unsortedArrays; // different variations of unsorted arrays
    Integer[][] sortedArrays; // sorted arrays

    public SortTests() {
        sortedArrays = new Integer[6][];
        sortedArrays[0] = new Integer[]{1, 2, 3, 4, 5, 7, 8, 9};
        sortedArrays[1] = new Integer[]{1, 2, 3, 4, 5, 7, 8, 9, 10};
        sortedArrays[2] = new Integer[]{1, 3, 4, 5, 7, 8, 9, 10};
        sortedArrays[3] = new Integer[]{0, 1, 3, 4, 5, 7, 8, 9};
        sortedArrays[4] = new Integer[]{0, 1, 2, 3, 4, 5, 8, 9};
        sortedArrays[5] = new Integer[]{1, 1, 2, 2, 2, 3, 3, 3, 4};

        unsortedArrays = new Integer[6][];
    }

    @Before
    public void init() {
        unsortedArrays[0] = new Integer[]{2, 8, 5, 3, 9, 4, 1, 7};
        unsortedArrays[1] = new Integer[]{2, 8, 5, 3, 9, 4, 1, 7, 10};
        unsortedArrays[2] = new Integer[]{10, 8, 5, 3, 9, 4, 1, 7};
        unsortedArrays[3] = new Integer[]{0, 8, 5, 3, 9, 4, 1, 7};
        unsortedArrays[4] = new Integer[]{2, 8, 5, 3, 9, 4, 1, 0};
        unsortedArrays[5] = new Integer[]{1, 3, 3, 2, 2, 1, 4, 3, 2};
    }

    @Test
    public void testBubbleSort() {
        Consumer<Integer[]> bubbleSort = BubbleSort::sort;
        sortArrays(unsortedArrays, bubbleSort);
        compareArrays(sortedArrays, unsortedArrays);
    }

    @Test
    public void testInsertionSort() {
        Consumer<Integer[]> insertionSort = InsertionSort::sort;
        sortArrays(unsortedArrays, insertionSort);
        compareArrays(sortedArrays, unsortedArrays);
    }

    @Test
    public void testSelectSort() {
        Consumer<Integer[]> selectSort = SelectSort::sort;
        sortArrays(unsortedArrays, selectSort);
        compareArrays(sortedArrays, unsortedArrays);
    }

    private void compareArrays(Integer[][] arrays1, Integer[][] arrays2) {
        Assert.assertEquals("Big arrays do not have same lengths!", arrays1.length, arrays2.length);

        for (int i = 0; i < arrays1.length; i++) {
            compareArrays(arrays1[i], arrays2[i], i);
        }
    }

    private void compareArrays(Integer[] array1, Integer[] array2, int arrayCounter) {
        Assert.assertEquals("Arrays do not have same lengths!", array1.length, array2.length);

        for (int i = 0; i < array1.length; i++) {
            Assert.assertEquals("Array " + arrayCounter + ": " + getArrayAsString(array1, "|")
                    + " and array " + arrayCounter + ": " + getArrayAsString(array2, "|")
                    + " not equal for index " + i, array1[i], array2[i]);
        }
    }

    public void sortArrays(Integer[][] arrays, Consumer<Integer[]> sortingMethod) {
        for (int i = 0; i < arrays.length; i++) {
            sortingMethod.accept(arrays[i]);
        }
    }

    private String getArrayAsString(Integer[] array, String delimiter) {
        return String.join(delimiter, Arrays.stream(array).map(e -> e + "").collect(Collectors.toList()));
    }
}