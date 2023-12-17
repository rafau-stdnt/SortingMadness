// Controller.java
package pl.put.poznan.SortingMadness.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.put.poznan.SortingMadness.data.InputData;
import pl.put.poznan.SortingMadness.sortingAlgorithms.InsertionSort;
import pl.put.poznan.SortingMadness.util.SortingUtil;

import java.util.ArrayList;
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

                String result;
                if ("arrayDesc".equals(order)) {
                    result = SortingUtil.of(arr, true);
                } else {
                    result = SortingUtil.of(arr, false);
                }

                sortedArray.add(result);
                time_for_html = InsertionSort.getTime();
                return ResponseEntity.ok(result);
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
