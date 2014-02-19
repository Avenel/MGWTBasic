package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

/**
 * Place for HomeActivity.
 * @author Martin
 *
 */
public class HomePlace extends Place implements PlaceJSONObject {

	/**
	 * Tokenizer class for ActivityPlace.
	 * @author Martin
	 *
	 */
	public static class HomePlaceTokenizer implements PlaceTokenizer<HomePlace> {

		@Override
		public HomePlace getPlace(String token) {
			return new HomePlace();
		}

		@Override
		public String getToken(HomePlace place) {
			return "";
		}
	
	
	}

	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"HomePlace\"}");
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			return true;
		}
		return false;
	}
}
