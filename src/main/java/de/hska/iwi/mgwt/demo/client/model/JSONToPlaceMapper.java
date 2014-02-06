package de.hska.iwi.mgwt.demo.client.model;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailPlace;

/**
 * Maps JSON to Places.
 * @author Martin
 *
 */
public class JSONToPlaceMapper {

	/**
	 * Maps a given Place in JSONValue form to the corresponding Place.
	 * @param jsonValue
	 * @return Place targetPlace
	 */
	public static Place toPlace(JSONValue jsonValue) {
		JSONArray jsonArray = null;
		
		jsonArray = jsonValue.isArray();
		if (jsonArray == null) {
			// Error, return to HomePlace
			return new HomePlace();
		}
		
		jsonValue = jsonArray.get(0);
		if (jsonValue.isObject().get("class").isString() == null) {
			// Error, return to HomePlace
			return new HomePlace();
		} else {
			String className = jsonValue.isObject().get("class").isString().stringValue(); 
			
			// ProcessDetailPlace
			if (className.compareTo("ProcessDetailPlace") == 0) {
				if (jsonValue.isObject().get("id").isNumber() == null) {
					// Error, return to HomePlace
					return new HomePlace();
				} else {
					return new ProcessDetailPlace(jsonValue.isObject().get("id").isString().stringValue());
				}
			}
		}
		
		
		// if no corresponding place is found, return HomePlace
		return new HomePlace();
	}
	
}
