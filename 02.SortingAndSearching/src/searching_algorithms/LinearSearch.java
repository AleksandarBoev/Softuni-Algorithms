package searching_algorithms;

public class LinearSearch {
    public int getElementIndex(Object element, Object[] array) {
        int result = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                result = i;
            }
        }

        return result;
    }
}
