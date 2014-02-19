package de.hska.iwi.mgwt.demo.client.activities.lecture;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

/**
 * Place for Lecture activity.
 * @author Martin
 *
 */
public class LecturePlace extends Place implements PlaceJSONObject {
	/**
	 * Tokenizer class for LecturePlace.
	 * @author Martin
	 *
	 */
	public static class LecturePlaceTokenizer implements PlaceTokenizer<LecturePlace> {

		@Override
		public LecturePlace getPlace(String token) {
			return new LecturePlace();
		}

		@Override
		public String getToken(LecturePlace place) {
			return "";
		}
	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"LecturePlace\"}");
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			return true;
		}
		return false;
	}
}
