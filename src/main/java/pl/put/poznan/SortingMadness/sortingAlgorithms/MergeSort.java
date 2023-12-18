package pl.put.poznan.SortingMadness.sortingAlgorithms;

public class MergeSort {

    private static long time;

    public static long getTime() {
        return time;
    }

    public static <T extends Comparable<T>> void sort(T[] array, boolean descending) {
        long startTime = System.nanoTime();

        mergeSort(array, descending);

        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, boolean descending) {
        int n = array.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        T[] leftArray = (T[]) new Comparable[mid];
        T[] rightArray = (T[]) new Comparable[n - mid];

        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, n - mid);

        mergeSort(leftArray, descending);
        mergeSort(rightArray, descending);

        merge(array, leftArray, rightArray, descending);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] leftArray, T[] rightArray, boolean descending) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if ((descending ? leftArray[i].compareTo(rightArray[j]) >= 0 : leftArray[i].compareTo(rightArray[j]) <= 0)) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }
}
