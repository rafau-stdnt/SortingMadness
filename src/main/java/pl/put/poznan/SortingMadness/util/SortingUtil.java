// SortingUtil.java
package pl.put.poznan.SortingMadness.util;

import pl.put.poznan.SortingMadness.sortingAlgorithms.InsertionSort;

import java.util.Arrays;

public class SortingUtil {

    public static <T extends Comparable<T>> String of(Object[] array, boolean descending) {
        if (array[0] instanceof Integer) {
            Integer[] integers = Arrays.copyOf(array, array.length, Integer[].class);
            InsertionSort.sort(integers, descending);
            return Arrays.toString(integers);
        } else if (array[0] instanceof Double) {
            Double[] doubles = Arrays.copyOf(array, array.length, Double[].class);
            InsertionSort.sort(doubles, descending);
            return Arrays.toString(doubles);
        } else if (array[0] instanceof String) {
            String[] strings = Arrays.copyOf(array, array.length, String[].class);
            InsertionSort.sort(strings, descending);
            return Arrays.toString(strings);
        } else {
            return "Invalid data type";
        }
    }
}
