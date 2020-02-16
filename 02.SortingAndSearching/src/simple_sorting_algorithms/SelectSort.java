package simple_sorting_algorithms;

public class SelectSort {
    public static<T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            T min = array[i];
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(min) < 0) {
                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}
