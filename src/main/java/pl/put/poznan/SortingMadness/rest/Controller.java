// Controller.java
package pl.put.poznan.SortingMadness.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.put.poznan.SortingMadness.data.InputData;
import pl.put.poznan.SortingMadness.sortingAlgorithms.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/SortingMadness")
public class Controller {

    private List<String> sortedArray;
    private String sortedOrder;
    private String time_for_html;

    @GetMapping
    public String hello() {
        return "TODO";
    }

    @PostMapping("/sort")
    public ResponseEntity<String> sort(@RequestBody InputData inputData) {
        try {
            Object[] arr = inputData.getArray();
            String order = inputData.getOrder();
            sortedOrder = order;

            if (arr.length > 0) {
                sortedArray = new ArrayList<>();

                if (arr[0] instanceof Integer) {
                    Integer[] integers = Arrays.copyOf(arr, arr.length, Integer[].class);
                    if ("arrayDesc".equals(order)) {
                        InsertionSort.sort(integers, true);
                    } else {
                        InsertionSort.sort(integers, false);
                    }
                    sortedArray.add(Arrays.toString(integers));
                    time_for_html = InsertionSort.getTime();
                    return ResponseEntity.ok(Arrays.toString(integers));
                } else if (arr[0] instanceof Double) {
                    Double[] doubles = Arrays.copyOf(arr, arr.length, Double[].class);
                    if ("arrayDesc".equals(order)) {
                        InsertionSort.sort(doubles, true);
                    } else {
                        InsertionSort.sort(doubles, false);
                    }
                    sortedArray.add(Arrays.toString(doubles));
                    return ResponseEntity.ok(Arrays.toString(doubles));
                } else if (arr[0] instanceof String) {
                    String[] strings = Arrays.copyOf(arr, arr.length, String[].class);
                    if ("arrayDesc".equals(order)) {
                        InsertionSort.sort(strings, true);
                    } else {
                        InsertionSort.sort(strings, false);
                    }
                    sortedArray.add(Arrays.toString(strings));
                    return ResponseEntity.ok(Arrays.toString(strings));
                } else {
                    return ResponseEntity.badRequest().body("Invalid data type");
                }
            } else {
                return ResponseEntity.badRequest().body("Invalid data");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid JSON");
        }
    }

    @GetMapping("/sort")
    public ModelAndView showResult(ModelAndView modelAndView) {
        modelAndView.addObject("array", sortedArray);
        modelAndView.addObject("order", sortedOrder);
        modelAndView.addObject("time", time_for_html);
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
