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
    public ResponseEntity<String> sort(@RequestBody InputData inputData) {
        try {
            Object[] arr = inputData.getArray();
            String order = inputData.getOrder();
            String algorithm = inputData.getAlgorithm();
            json_order = order;
            json_algorithm = algorithm;

            if (arr.length > 0) {
                sortedArray = new ArrayList<>();

                String result = SortingUtil.of(arr, algorithm, order);
                sortedArray.add(result);
                json_time = SortingUtil.getTime();
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("Invalid data");
            }
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

