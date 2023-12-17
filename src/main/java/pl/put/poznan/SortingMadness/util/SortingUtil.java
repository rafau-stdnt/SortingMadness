package pl.put.poznan.SortingMadness.util;

import pl.put.poznan.SortingMadness.sortingAlgorithms.InsertionSort;
import pl.put.poznan.SortingMadness.sortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class SortingUtil {

    private static long time;

    public static String getTime() {
        return String.format("%.3f", time / 1000000.0);
    }

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

    private static <T extends Comparable<T>> void sort(T[] array, String algorithm, boolean descending) {
        switch (algorithm.toLowerCase()) {
            case "insertion":
                InsertionSort.sort(array, descending);
                time = InsertionSort.getTime();
                break;
            case "selection":
                SelectionSort.sort(array, descending);
                time = SelectionSort.getTime();
                break;
            // Добавьте другие алгоритмы, если необходимо
            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }
    }
}
