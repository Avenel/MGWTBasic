package de.hska.iwi.mgwt.demo.client.activities.settings;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class SettingsPlace extends Place implements PlaceJSONObject {
	public static class SettingsPlaceTokenizer implements PlaceTokenizer<SettingsPlace> {

		@Override
		public SettingsPlace getPlace(String token) {
			return new SettingsPlace();
		}

		@Override
		public String getToken(SettingsPlace place) {
			return "";
		}
	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"SettingsPlace\"}");
	}
}
