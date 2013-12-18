
package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {

    private String name;
    private Double priceStudent;
    private Double priceGuest;
    private Double priceEmployee;
    private Double pricePupil;
    private Object priceAdditive;
    private List<Integer> foodAdditiveNumbers = new ArrayList<Integer>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceStudent() {
        return priceStudent;
    }

    public void setPriceStudent(Double priceStudent) {
        this.priceStudent = priceStudent;
    }

    public Double getPriceGuest() {
        return priceGuest;
    }

    public void setPriceGuest(Double priceGuest) {
        this.priceGuest = priceGuest;
    }

    public Double getPriceEmployee() {
        return priceEmployee;
    }

    public void setPriceEmployee(Double priceEmployee) {
        this.priceEmployee = priceEmployee;
    }

    public Double getPricePupil() {
        return pricePupil;
    }

    public void setPricePupil(Double pricePupil) {
        this.pricePupil = pricePupil;
    }

    public Object getPriceAdditive() {
        return priceAdditive;
    }

    public void setPriceAdditive(Object priceAdditive) {
        this.priceAdditive = priceAdditive;
    }

    public List<Integer> getFoodAdditiveNumbers() {
        return foodAdditiveNumbers;
    }

    public void setFoodAdditiveNumbers(List<Integer> foodAdditiveNumbers) {
        this.foodAdditiveNumbers = foodAdditiveNumbers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
