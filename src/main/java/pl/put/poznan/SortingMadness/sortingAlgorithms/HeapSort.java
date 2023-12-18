package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class HeapSort {
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
     * Sorts an array of elements in ascending or descending order using the heap sort algorithm.
     *
     * @param  array      the array of elements to be sorted
     * @param  descending true if the array should be sorted in descending order, false otherwise
     */
    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        heapSort(array, descending);

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

    /**
     * Sorts an array of elements in ascending or descending order using the heap sort algorithm.
     *
     * @param  array      the array of elements to be sorted
     * @param  descending true if the array should be sorted in descending order, false otherwise
     */
    private static <T extends Comparable<T>> void heapSort(T[] array, boolean descending) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, descending);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0, descending);
        }
    }

    /**
     * Heapify the array from index i to n.
     *
     * @param  array      the array to be heapified
     * @param  n          the size of the array
     * @param  i          the starting index
     * @param  descending true if the heap should be in descending order, false if in ascending order
     */
    private static <T extends Comparable<T>> void heapify(T[] array, int n, int i, boolean descending) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
    
        if (left < n && (descending ? array[left].compareTo(array[largest]) < 0 : array[left].compareTo(array[largest]) > 0)) {
            largest = left;
        }
    
        if (right < n && (descending ? array[right].compareTo(array[largest]) < 0 : array[right].compareTo(array[largest]) > 0)) {
            largest = right;
        }
    
        if (largest != i) {
            T swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
    
            heapify(array, n, largest, descending);
        }
    }
    
}
