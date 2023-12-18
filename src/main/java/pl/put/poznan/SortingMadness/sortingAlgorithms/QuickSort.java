package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class QuickSort {

    private static long time;

    public static long getTime() {
        return time;
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        quickSort(array, 0, array.length - 1, descending);

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, boolean descending) {
        if (low < high) {
            int partitionIndex = partition(array, low, high, descending);

            quickSort(array, low, partitionIndex - 1, descending);
            quickSort(array, partitionIndex + 1, high, descending);
        }
    }

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
