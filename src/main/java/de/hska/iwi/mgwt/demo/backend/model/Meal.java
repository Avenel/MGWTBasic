//
//package de.hska.iwi.mgwt.demo.backend.model;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import de.hska.iwi.mgwt.demo.backend.autobean.IMeal;
//
//public class Meal implements IMeal {
//
//    private String name;
//    private Double priceStudent;
//    private Double priceGuest;
//    private Double priceEmployee;
//    private Double pricePupil;
//    private Object priceAdditive;
//    private List<Integer> foodAdditiveNumbers = new ArrayList<Integer>();
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//
//    @Override
//	public String getName() {
//        return name;
//    }
//
//    @Override
//	public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//	public Double getPriceStudent() {
//        return priceStudent;
//    }
//
//    @Override
//	public void setPriceStudent(Double priceStudent) {
//        this.priceStudent = priceStudent;
//    }
//
//    @Override
//	public Double getPriceGuest() {
//        return priceGuest;
//    }
//
//    @Override
//	public void setPriceGuest(Double priceGuest) {
//        this.priceGuest = priceGuest;
//    }
//
//    @Override
//	public Double getPriceEmployee() {
//        return priceEmployee;
//    }
//
//    @Override
//	public void setPriceEmployee(Double priceEmployee) {
//        this.priceEmployee = priceEmployee;
//    }
//
//    @Override
//	public Double getPricePupil() {
//        return pricePupil;
//    }
//
//    @Override
//	public void setPricePupil(Double pricePupil) {
//        this.pricePupil = pricePupil;
//    }
//
//    @Override
//	public Object getPriceAdditive() {
//        return priceAdditive;
//    }
//
//    @Override
//	public void setPriceAdditive(Object priceAdditive) {
//        this.priceAdditive = priceAdditive;
//    }
//
//    @Override
//	public List<Integer> getFoodAdditiveNumbers() {
//        return foodAdditiveNumbers;
//    }
//
//    @Override
//	public void setFoodAdditiveNumbers(List<Integer> foodAdditiveNumbers) {
//        this.foodAdditiveNumbers = foodAdditiveNumbers;
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
