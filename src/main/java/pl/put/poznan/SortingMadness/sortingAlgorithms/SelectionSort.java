package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class SelectionSort {

    private static long time;

    public static long getTime() {
        return time;
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if ((descending ? array[j].compareTo(array[minIndex]) > 0 : array[j].compareTo(array[minIndex]) < 0)) {
                    minIndex = j;
                }
            }

            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        long endTime = System.nanoTime();
        time = endTime - startTime;

    }

}
