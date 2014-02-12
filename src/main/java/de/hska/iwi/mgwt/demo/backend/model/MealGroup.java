//
//package de.hska.iwi.mgwt.demo.backend.model;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import de.hska.iwi.mgwt.demo.backend.autobean.IMeal;
//import de.hska.iwi.mgwt.demo.backend.autobean.IMealGroup;
//
//public class MealGroup implements IMealGroup {
//
//    private String title;
//    private List<IMeal> meals = new ArrayList<IMeal>();
//    private String message;
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @Override
//	public String getTitle() {
//        return title;
//    }
//
//    @Override
//	public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @Override
//	public List<IMeal> getMeals() {
//        return meals;
//    }
//
//    @Override
//	public void setMeals(List<IMeal> meals) {
//        this.meals = meals;
//    }
//
//    @Override
//	public String getMessage() {
//        return message;
//    }
//
//    @Override
//	public void setMessage(String message) {
//        this.message = message;
//    }
//
//    @Override
//	public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @Override
//	public void setAdditionalProperties(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//}
