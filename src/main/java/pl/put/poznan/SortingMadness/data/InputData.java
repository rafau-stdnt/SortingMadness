package pl.put.poznan.SortingMadness.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputData {
    @JsonProperty("array")
    private Object[] array;

    @JsonProperty("order")
    private String order;

    @JsonProperty("algorithm")
    private String algorithm;

    public Object[] getArray() {
        return array;
    }

    public String getOrder() {
        return order;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}
