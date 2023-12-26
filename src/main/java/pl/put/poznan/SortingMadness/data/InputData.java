package pl.put.poznan.SortingMadness.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputData {
    @JsonProperty("array")
    private Object[] array;

    @JsonProperty("order")
    private String order;

    @JsonProperty("algorithm")
    private String algorithm;

    /**
     * Retrieves the array stored in the object.
     *
     * @return an array of objects
     */
    public Object[] getArray() {
        return array;
    }

    /**
     * Retrieves the order.
     *
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * Returns the algorithm used in the function.
     *
     * @return the algorithm used
     */
    public String getAlgorithm() {
        return algorithm;
    }

}
