package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

/**
 * Place for MensaActivity.
 * @author Martin
 *
 */
public class MensaPlace extends Place implements PlaceJSONObject {

	/**
	 * Tokenizer class for MensaPlace.
	 * @author Martin
	 *
	 */
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
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			return true;
		}
		return false;
	}
	
}
