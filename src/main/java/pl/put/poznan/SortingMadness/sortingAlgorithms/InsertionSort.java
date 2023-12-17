package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class InsertionSort {

    private static long time;

    public static long getTime() {
        return time;
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && (descending ? array[j].compareTo(key) < 0 : array[j].compareTo(key) > 0)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }
}
