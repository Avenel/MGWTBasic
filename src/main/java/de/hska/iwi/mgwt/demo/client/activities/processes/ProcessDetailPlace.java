package de.hska.iwi.mgwt.demo.client.activities.processes;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;
/**
 * The place for a ProcessDetailActivity. Currently only used with Seminars
 * @author Simon
 *
 */
public class ProcessDetailPlace extends Place implements PlaceJSONObject {
	String id;
	
	public ProcessDetailPlace(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	/**
	 * Tokenizer class for Place
	 * @author Simon
	 *
	 */
	public static class ProcessDetailPlaceTokenizer implements PlaceTokenizer<ProcessDetailPlace> {

		@Override
		public ProcessDetailPlace getPlace(String id) {
			return new ProcessDetailPlace(id);
		}

		@Override
		public String getToken(ProcessDetailPlace place) {
			return place.getId();
		}

	}
	
	@Override
	public JSONValue toJson() {
		String jsonString = new String();
		
		jsonString += "{";
		jsonString += "\"className\": \"ProcessDetailPlace\", ";
		jsonString += "\"id\": " + this.id;
		jsonString += "}";
		
		JSONValue jsonValue = JSONParser.parseStrict(jsonString);
		return jsonValue;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			if (((ProcessDetailPlace) o).id.compareTo(this.id) == 0) {
				return true;
			}
		}
		return false;
	}
}
