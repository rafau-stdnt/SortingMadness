package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class BubbleSort {
    private static long time;

    /**
     * Get the current time.
     *
     * @return  the current time in milliseconds
     */
    public static long getTime() {
        return time;
    }

    /**
     * Sorts an array of elements in ascending or descending order.
     *
     * @param  array      the array to be sorted
     * @param  descending true if the array should be sorted in descending order, false for ascending order
     */
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
