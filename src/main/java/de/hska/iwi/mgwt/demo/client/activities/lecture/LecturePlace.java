package de.hska.iwi.mgwt.demo.client.activities.lecture;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class LecturePlace extends Place implements PlaceJSONObject {
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
}
