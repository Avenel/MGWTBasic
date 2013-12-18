
package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MensaMenu {

    private String name;
    private List<MealGroup> mealGroups = new ArrayList<MealGroup>();
    private String status;
    private String date;
    private Map<String, Integer> additionalProperties = new HashMap<String, Integer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MealGroup> getMealGroups() {
        return mealGroups;
    }

    public void setMealGroups(List<MealGroup> mealGroups) {
        this.mealGroups = mealGroups;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Integer> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String name, Integer value) {
        this.additionalProperties.put(name, value);
    }

}
