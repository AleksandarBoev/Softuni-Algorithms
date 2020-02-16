package simple_sorting_algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{2, 8, 5, 3, 9, 4, 1, 7};

        System.out.println("Before sort: " + getArrayAsString(array, " | "));

        BubbleSort.sort(array);

        System.out.println("After sort: " + getArrayAsString(array, " | "));
    }

    public static<T> String getArrayAsString(T[] array, String delimiter) {
        return String.join(delimiter, Arrays.stream(array).map(e -> e + "").collect(Collectors.toList()));
    }
}
