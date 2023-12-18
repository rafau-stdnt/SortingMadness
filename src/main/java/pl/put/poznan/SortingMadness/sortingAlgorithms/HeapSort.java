package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class HeapSort {
    private static long time;

    public static long getTime() {
        return time;
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        heapSort(array, descending);

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

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
