package de.hska.iwi.mgwt.demo.client.model;

import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarPlace;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;

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
		if (jsonValue.isObject().get("className").isString() == null) {
			// Error, return to HomePlace
			return new HomePlace();
		} else {
			String className = jsonValue.isObject().get("className").isString().stringValue(); 
			
			// ProcessDetailPlace
			if (className.compareTo("ProcessDetailPlace") == 0) {
				if (jsonValue.isObject().get("id").isNumber() == null) {
					// Error, return to HomePlace
					return new HomePlace();
				} else {
					return new ProcessDetailPlace(jsonValue.isObject().get("id").isNumber().toString());
				}
			}
			
			if (className.compareTo("HomePlace") == 0) {
				return new HomePlace();
			}
			
			if (className.compareTo("LecturePlace") == 0) {
				return new LecturePlace();
			}
			
			if (className.compareTo("MensaPlace") == 0) {
				return new MensaPlace();
			}
			
			if (className.compareTo("NewsPlace") == 0) {
				return new NewsPlace();
			}
			
			if (className.compareTo("StudentPlace") == 0) {
				return new StudentPlace();
			}
			
			if (className.compareTo("ProcessSeminarPlace") == 0) {
				return new ProcessSeminarPlace();
			}
			
			if (className.compareTo("SettingsPlace") == 0) {
				if (jsonValue.isObject().get("id").isNumber() == null) {
					// Error, return to HomePlace
					return new HomePlace();
				} else {
					return new SettingsPlace(jsonValue.isObject().get("id").isNumber().toString());
				}
			}
		}
		
		
		// if no corresponding place is found, return HomePlace
		return new HomePlace();
	}
	
}
