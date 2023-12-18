package pl.put.poznan.SortingMadness.util;

import pl.put.poznan.SortingMadness.sortingAlgorithms.BubbleSort;
import pl.put.poznan.SortingMadness.sortingAlgorithms.HeapSort;
import pl.put.poznan.SortingMadness.sortingAlgorithms.InsertionSort;
import pl.put.poznan.SortingMadness.sortingAlgorithms.MergeSort;
import pl.put.poznan.SortingMadness.sortingAlgorithms.QuickSort;
import pl.put.poznan.SortingMadness.sortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class SortingUtil {

    private static long time;

    /**
     * Returns a string representing the time value in a specific format.
     *
     * @return the formatted time value as a string
     */
    public static String getTime(String algorithm) {
        switch (algorithm.toLowerCase()) {
            case "insertionsort":
                return String.format("%.3f", InsertionSort.getTime() / 1000000.0);
            case "selectionsort":
                return String.format("%.3f", SelectionSort.getTime() / 1000000.0);
            case "bubblesort":
                return String.format("%.3f", BubbleSort.getTime() / 1000000.0);
            case "quicksort":
                return String.format("%.3f", QuickSort.getTime() / 1000000.0);
            case "mergesort":
                return String.format("%.3f", MergeSort.getTime() / 1000000.0);
            case "heapsort":
                return String.format("%.3f", HeapSort.getTime() / 1000000.0);
            default:
                return "Unknown algorithm";
        }
    }


    /**
     * Generates a string representation of the sorted array based on the specified algorithm and order.
     *
     * @param  array     the array to be sorted
     * @param  algorithm the sorting algorithm to use
     * @param  order     the order in which to sort the array ("asc" for ascending, "desc" for descending)
     * @return           a string representation of the sorted array
     */
    public static <T extends Comparable<T>> String of(Object[] array, String algorithm, String order) {
        boolean descending = order != null && order.equalsIgnoreCase("desc");

        if (array[0] instanceof Integer) {
            Integer[] integers = Arrays.copyOf(array, array.length, Integer[].class);
            sort(integers, algorithm, descending);
            return Arrays.toString(integers);
        } else if (array[0] instanceof Double) {
            Double[] doubles = Arrays.copyOf(array, array.length, Double[].class);
            sort(doubles, algorithm, descending);
            return Arrays.toString(doubles);
        } else if (array[0] instanceof String) {
            String[] strings = Arrays.copyOf(array, array.length, String[].class);
            sort(strings, algorithm, descending);
            return Arrays.toString(strings);
        } else {
            return "Invalid data type";
        }
    }

    /**
     * Sorts an array using the specified algorithm.
     *
     * @param  array      the array to be sorted
     * @param  algorithm  the algorithm to be used for sorting (e.g., "insertion", "selection")
     * @param  descending true if the array should be sorted in descending order, false otherwise
     */
    private static <T extends Comparable<T>> void sort(T[] array, String algorithm, boolean descending) {
        switch (algorithm.toLowerCase()) {
            case "insertionsort":
                InsertionSort.sort(array, descending);
                time = InsertionSort.getTime();
                break;
            case "selectionsort":
                SelectionSort.sort(array, descending);
                time = SelectionSort.getTime();
                break;
            case "bubblesort":
                BubbleSort.sort(array, descending);
                time = BubbleSort.getTime();
                break;
            case "quicksort":
                QuickSort.sort(array, descending);
                time = QuickSort.getTime();
                break;
            case "mergesort":
                MergeSort.sort(array, descending);
                time = MergeSort.getTime();
                break;
            case "heapsort":
                HeapSort.sort(array, descending);
                time = HeapSort.getTime();
                break;
            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }
    }
}
