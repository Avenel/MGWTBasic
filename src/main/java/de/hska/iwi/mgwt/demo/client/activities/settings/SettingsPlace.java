package de.hska.iwi.mgwt.demo.client.activities.settings;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;

public class SettingsPlace extends Place implements PlaceJSONObject {
	String id;

	public SettingsPlace(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static class SettingsPlaceTokenizer implements PlaceTokenizer<SettingsPlace> {

		@Override
		public SettingsPlace getPlace(String token) {
			return new SettingsPlace(token);
		}

		@Override
		public String getToken(SettingsPlace place) {
			return place.getId();
		}
	}
	
	@Override
	public JSONValue toJson() {
		String jsonString = new String();
		
		jsonString += "{";
		jsonString += "\"className\": \"SettingsPlace\", ";
		jsonString += "\"id\": \"" + this.id + "\"";
		jsonString += "}";
		
		JSONValue jsonValue = JSONParser.parseStrict(jsonString);
		return jsonValue;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o.getClass().toString().compareTo(this.getClass().toString()) == 0) {
			if (((SettingsPlace) o).id.compareTo(this.id) == 0) {
				return true;
			}
		}
		return false;
	}
}
