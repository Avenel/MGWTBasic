package de.hska.iwi.mgwt.demo.client.activities.processes;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class StudentPlace extends Place implements PlaceJSONObject {
	public static class StudentPlaceTokenizer implements PlaceTokenizer<StudentPlace> {

		@Override
		public StudentPlace getPlace(String token) {
			return new StudentPlace();
		}

		@Override
		public String getToken(StudentPlace place) {
			return "";
		}

	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"StudentPlace\"}");
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			return true;
		}
		return false;
	}
}
