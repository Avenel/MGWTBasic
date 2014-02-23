package de.hska.iwi.mgwt.demo.client.model;

import com.google.gwt.json.client.JSONValue;

import de.hska.iwi.mgwt.demo.client.widget.Tile;

/**
 * Interface for serializing a tile into a json Object.
 * 
 * TODO: Perhaps use in future a generic class, if one has to (de-) serialize more and 
 * more classes.
 * @author Martin
 *
 */
public interface TileJSONObject {

	/**
	 * Deserialize a JSONValue into a tile instance.
	 * @param jsonValue
	 * @return Tile instance
	 */
	public Tile toTile(JSONValue jsonValue);
	
	/**
	 * Serialize tile into a JSONValue.
	 * @return JSONValue json object
	 */
	public JSONValue toJSON();
}
