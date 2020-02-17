package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class P05Needles {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        consoleReader.readLine(); // first line is kind of useless
        int[] inputElements = Arrays.stream(consoleReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeMap<Integer, Pair> valueIndices = new TreeMap<>();

        for (int i = 0; i < inputElements.length; i++) {
            if (inputElements[i] == 0) {
                continue;
            }

            Pair pair = valueIndices.get(inputElements[i]);

            if (pair == null) {
                pair = new Pair(i);
                valueIndices.put(inputElements[i], pair);
            } else {
                pair.lastIndex = i;
            }
        }

        int[] elementsToFindIndices = Arrays.stream(consoleReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        consoleReader.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elementsToFindIndices.length; i++) {
            Map.Entry<Integer, Pair> smallerEntry = valueIndices.floorEntry(elementsToFindIndices[i] - 1);

            if (smallerEntry == null) {
                result.append(0).append(" ");
            } else {
                result.append(smallerEntry.getValue().lastIndex + 1).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }

    static class Pair {
        int firstIndex;
        int lastIndex;

        public Pair(int firstIndex) {
            this.firstIndex = firstIndex;
            lastIndex = firstIndex;
        }

        public void setLastIndex(int lastIndex) {
            this.lastIndex = lastIndex;
        }
    }
}
