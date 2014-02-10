package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class ProcessSeminarPlace extends Place implements PlaceJSONObject {
	public static class ProcessSeminarPlaceTokenizer implements PlaceTokenizer<ProcessSeminarPlace> {

		@Override
		public ProcessSeminarPlace getPlace(String token) {
			return new ProcessSeminarPlace();
		}

		@Override
		public String getToken(ProcessSeminarPlace place) {
			return "";
		}

	}
	
	@Override
	public JSONValue toJson() {
		return JSONParser.parseStrict("{\"className\": \"ProcessSeminarPlace\"}");
	}

	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			return true;
		}
		return false;
	}
	
}
