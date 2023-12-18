package pl.put.poznan.SortingMadness.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.put.poznan.SortingMadness.data.InputData;
import pl.put.poznan.SortingMadness.util.SortingUtil;

import java.util.*;

@RestController
@RequestMapping("/SortingMadness")
public class Controller {

    private List<String> sortedArray;
    private String json_order;
    private String json_time;
    private String json_algorithm;

    @GetMapping
    public String hello() {
        return "TODO";
    }

    /**
     * Sorts the given array using the specified algorithm and order.
     *
     * @param  inputData  the input data containing the array, algorithm, and order
     * @return            the sorted array as a string
     */
    @PostMapping("/sort")
    public ResponseEntity<?> sort(@RequestBody InputData inputData) {
        try {
            Object[] arr = inputData.getArray();
            String order = inputData.getOrder();
            String algorithm = inputData.getAlgorithm();
            json_order = order;
            json_algorithm = algorithm;

            if ("allsorts".equalsIgnoreCase(algorithm)) {
                sortedArray = new ArrayList<>();

                // Insertion Sort
                String insertionSortResult = SortingUtil.of(arr, "insertionsort", order);
                sortedArray.add("Insertion sort: " + insertionSortResult);

                // Selection Sort
                String selectionSortResult = SortingUtil.of(arr, "selectionsort", order);
                sortedArray.add("Selection sort: " + selectionSortResult);

                // Bubble Sort
                String bubbleSortResult = SortingUtil.of(arr, "bubblesort", order);
                sortedArray.add("Bubble sort: " + bubbleSortResult);

                // Quick Sort
                String quickSortResult = SortingUtil.of(arr, "quicksort", order);
                sortedArray.add("Quick sort: " + quickSortResult);

                // Merge Sort
                String mergeSortResult = SortingUtil.of(arr, "mergesort", order);
                sortedArray.add("Merge sort: " + mergeSortResult);

                // Heap Sort
                String heapSortResult = SortingUtil.of(arr, "heapsort", order);
                sortedArray.add("Heap sort: " + heapSortResult);

                json_time = "Insertion sort: " + SortingUtil.getTime("insertionsort") + " milliseconds, " +
                        "Selection sort: " + SortingUtil.getTime("selectionsort") + " milliseconds, " +
                        "Bubble sort: " + SortingUtil.getTime("bubblesort") + " milliseconds, " +
                        "Quick sort: " + SortingUtil.getTime("quicksort") + " milliseconds, " +
                        "Merge sort: " + SortingUtil.getTime("mergesort") + " milliseconds, " +
                        "Heap sort: " + SortingUtil.getTime("heapsort") + " milliseconds";
            } else if (arr.length > 0) {
                // Process the case when a specific algorithm is provided
                sortedArray = new ArrayList<>();

                String result = SortingUtil.of(arr, algorithm, order);
                sortedArray.add(result);
                json_time = SortingUtil.getTime(algorithm);
            } else {
                return ResponseEntity.badRequest().body("Invalid data");
            }

            return ResponseEntity.ok("Sorting completed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid JSON");
        }
    }



    /**
     * Retrieves the sorted array, order, time, and algorithm, and sets them as attributes in the ModelAndView object.
     *
     * @param  modelAndView   the ModelAndView object to which the attributes will be added
     * @return                the ModelAndView object with the attributes set
     */
    @GetMapping("/sort")
    public ModelAndView showResult(ModelAndView modelAndView) {
        modelAndView.addObject("array", sortedArray);
        modelAndView.addObject("order", json_order);
        modelAndView.addObject("time", json_time);
        modelAndView.addObject("algorithm", json_algorithm);
        modelAndView.setViewName("result");
        return modelAndView;
    }

    /**
     * Retrieves a sorted array as JSON.
     *
     * @return        The response entity containing the JSON representation of the sorted array.
     */
    @GetMapping("/json")
    public ResponseEntity<Object> getSortedArrayAsJson() {
        if (sortedArray != null && !sortedArray.isEmpty()) {
            String algorithm = json_algorithm;
            String order = json_order;

            Map<String, Object> outputData = new HashMap<>();
            outputData.put("time", json_time);
            outputData.put("algorithm", algorithm);
            outputData.put("order", order);
            outputData.put("sortedArray", sortedArray.get(0));

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(outputData);
        } else {
            return ResponseEntity.badRequest().body("Invalid data");
        }
    }

}

