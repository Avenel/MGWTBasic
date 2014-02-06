package de.hska.iwi.mgwt.demo.client.model;

import com.google.gwt.json.client.JSONValue;

import de.hska.iwi.mgwt.demo.client.widget.Tile;

public interface TileJSONObject {

	public Tile toTile(JSONValue jsonValue);
	public JSONValue toJSON();
}
