package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class MensaPlace extends Place implements PlaceJSONObject {

	public static class MensaPlaceTokenizer implements PlaceTokenizer<MensaPlace> {

		@Override
		public MensaPlace getPlace(String token) {
			return new MensaPlace();
		}

		@Override
		public String getToken(MensaPlace place) {
			return "";
		}
	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"MensaPlace\"}");
	}
	
}
