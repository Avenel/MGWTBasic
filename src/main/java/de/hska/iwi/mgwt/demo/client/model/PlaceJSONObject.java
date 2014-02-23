package de.hska.iwi.mgwt.demo.client.model;

import com.google.gwt.json.client.JSONValue;

/**
 * Interface class for places which have to be serialized into 
 * json objects (so one can store them into local stage, necessary for
 * home screen tiles. Each tile points to a different place.)
 * @author Martin
 *
 */
public interface PlaceJSONObject {

	/**
	 * Serializes object into a JSONValue.
	 * @return JSONValue serialized json object.
	 */
	public JSONValue toJson();
	
}
