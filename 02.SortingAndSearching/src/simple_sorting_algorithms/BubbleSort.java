package simple_sorting_algorithms;

public class BubbleSort {
    /*
    Минава по колекцията и разменя съседни елементи. По-малкият да е от ляво, по-големият да е от дясно.
    По този начин най-големия елемент в структурата винаги ще бъде изместен с по една позиция надясно
    и като балонче ще изплува т.е. ще бъде на последния индекс. И следващата итерация се прави до
    предпоследния елемент, защото се знае че най-големият е вече накрая. И така всяка следваща
    итерация ще бъде до по-малък и по-малък индекс, защото най-големите елементи се позиционират накрая.
     */
    public static <T extends Comparable<T>> void  sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int currentIndex = 1; currentIndex < array.length - i; currentIndex++) {
                if (array[currentIndex - 1].compareTo(array[currentIndex]) > 0) {
                    T temporary = array[currentIndex - 1];
                    array[currentIndex - 1] = array[currentIndex];
                    array[currentIndex] = temporary;
                }
            }
        }
    }
}
