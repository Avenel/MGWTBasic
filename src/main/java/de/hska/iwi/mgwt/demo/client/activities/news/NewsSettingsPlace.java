package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class NewsSettingsPlace extends Place implements PlaceJSONObject {

	public static class NewsSettingsPlaceTokenizer implements PlaceTokenizer<NewsSettingsPlace> {

		@Override
		public NewsSettingsPlace getPlace(String token) {
			return new NewsSettingsPlace();
		}

		@Override
		public String getToken(NewsSettingsPlace place) {
			return "";
		}
	
	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"NewsSettingsPlace\"}");
	}

}
