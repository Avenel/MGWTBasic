package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class NewsPlace extends Place implements PlaceJSONObject {

	public static class NewsPlaceTokenizer implements PlaceTokenizer<NewsPlace> {

		@Override
		public NewsPlace getPlace(String token) {
			return new NewsPlace();
		}

		@Override
		public String getToken(NewsPlace place) {
			return "";
		}

	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"NewsPlace\"}");
	}

}
