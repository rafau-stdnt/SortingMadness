package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class QuickSort {

    private static long time;

    /**
     * Returns the value of the time variable.
     *
     * @return the value of the time variable
     */
    public static long getTime() {
        return time;
    }

    /**
     * Sorts an array of comparable objects in ascending or descending order.
     *
     * @param  array      the array to be sorted
     * @param  descending true if the array should be sorted in descending order, false otherwise
     */
    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        quickSort(array, 0, array.length - 1, descending);

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

    /**
     * Sorts the given array using the QuickSort algorithm.
     *
     * @param  array      the array to be sorted
     * @param  low        the starting index of the array
     * @param  high       the ending index of the array
     * @param  descending a flag indicating whether to sort in descending order
     */
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, boolean descending) {
        if (low < high) {
            int partitionIndex = partition(array, low, high, descending);

            quickSort(array, low, partitionIndex - 1, descending);
            quickSort(array, partitionIndex + 1, high, descending);
        }
    }

    /**
     * Partitions an array based on a pivot element.
     *
     * @param  array      the array to be partitioned
     * @param  low        the starting index of the partition
     * @param  high       the ending index of the partition
     * @param  descending determines whether the array should be sorted in descending order
     * @return the index of the pivot element after partitioning
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, boolean descending) {
        T pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if ((descending ? array[j].compareTo(pivot) >= 0 : array[j].compareTo(pivot) <= 0)) {
                i++;

                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
