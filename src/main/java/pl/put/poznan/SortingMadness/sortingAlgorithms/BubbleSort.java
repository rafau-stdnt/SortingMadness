package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class BubbleSort {
    private static long time;

    public static long getTime() {
        return time;
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((descending ? array[j].compareTo(array[j + 1]) < 0 : array[j].compareTo(array[j + 1]) > 0)) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }
}
