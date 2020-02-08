package exercise;

import java.util.ArrayDeque;

public class P04TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4;

        ArrayDeque<Integer> source = new ArrayDeque<>(n);
        ArrayDeque<Integer> destination = new ArrayDeque<>(n);
        ArrayDeque<Integer> spare = new ArrayDeque<>(n);

        for (int i = 1; i <= n; i++) { // bigger number = larger disk
            source.addFirst(i);
        }

        // First element is at the bottom and is the biggest one.
        Rod sourceRod = new Rod("First Rod", source);
        Rod destinationRod = new Rod("Second Rod", destination);
        Rod spareRod = new Rod("Third Rod", spare);

        towerOfHanoi(n, sourceRod, destinationRod, spareRod);

        System.out.println(sourceRod);
        System.out.println(destinationRod);
        System.out.println(spareRod);
    }

    /*
    Confusing algorithm. Source, destination and spare are swapped as parameters in the recursive calls and that's
    how disks go from one place to another using all 3 rods.
     */
    private static void towerOfHanoi(int currentDisk, Rod sourceRod, Rod destinationRod, Rod spareRod) {
        if (currentDisk == 1) { // base case. Smallest disk, which is on top in the beginning.
            int disk = sourceRod.removeLast();
            destinationRod.addLast(disk);
            System.out.printf("Move disk %d from \"%s\" to \"%s\"%n", disk, sourceRod.name, destinationRod.name);
        } else {
            towerOfHanoi(currentDisk - 1, sourceRod, spareRod, destinationRod);

            int disk = sourceRod.removeLast();
            destinationRod.addLast(disk);
            System.out.printf("Move disk %d from \"%s\" to \"%s\"%n", disk, sourceRod.name, destinationRod.name);

            towerOfHanoi(currentDisk - 1, spareRod, destinationRod, sourceRod);
        }
    }

    //For easier debugging and understanding of algorithm.
    private static class Rod {
        private String name;
        private ArrayDeque<Integer> data;

        public Rod(String name, ArrayDeque<Integer> data) {
            this.name = name;
            this.data = data;
        }

        public Integer removeFirst() {
            return data.removeFirst();
        }

        public void addLast(Integer disk) {
            data.addLast(disk);
        }

        public Integer removeLast() {
            return data.removeLast();
        }

        public void addFirst(Integer disk) {
            data.addFirst(disk);
        }

        @Override
        public String toString() {
            return name + " -> " + data.toString();
        }
    }
}
