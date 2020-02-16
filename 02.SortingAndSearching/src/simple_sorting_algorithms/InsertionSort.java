package simple_sorting_algorithms;

public class InsertionSort {
    /*
    Минава се индекс по индекс. Ако текущият елемент е по-малък от предния, то тогава започни да го
    движиш (swap-ваш) толкова наляво, колкото е нужно, докато не си намери мястото между елементите
    или не стане първи. Ползва се като второстепенен алгоритъм (част от други сортирания)
    в случай на малко на брой елементи или за до-сортиране.
     */
    public static<T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
