// InputData.java
package pl.put.poznan.SortingMadness.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputData {
    @JsonProperty("array")
    private Object[] array;

    @JsonProperty("order")
    private String order;

    public Object[] getArray() {
        return array;
    }

    public String getOrder() {
        return order;
    }

}
