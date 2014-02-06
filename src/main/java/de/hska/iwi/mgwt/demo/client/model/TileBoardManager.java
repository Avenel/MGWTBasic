package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentPlace;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;
import de.hska.iwi.mgwt.demo.client.widget.Tile;

/**
 * Manages tiles on TileBoard. In future it can load tiles, stored in files on the clientside.
 * @author Martin
 *
 */
public class TileBoardManager {

	static List<Tile> tiles;
	private static Storage stockStore;
	
	/**
	 * Bootstrap, add necessary tiles.
	 */
	public static void initTiles() {		
		tiles = new ArrayList<Tile>();
		
		// first - look after existing tiles in storage
		stockStore = Storage.getLocalStorageIfSupported();
		
		if (stockStore.getItem(StorageKey.HomeScreenTiles.toString()) != null) {
			// load them
			JSONArray jsonArray = (JSONArray) JSONParser.parseStrict(stockStore.getItem(StorageKey.HomeScreenTiles.toString()));
			
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject currentObject = (JSONObject) jsonArray.get(i);
				
				Tile newTile = new Tile();
				newTile = newTile.toTile(currentObject);
				tiles.add(newTile);
			}
		} 
		else {
			// tiles not exists? create the default tiles.
			// News Tile
			Tile newsTile = new Tile("fa-bullhorn fa-3x", "Aktuelles", new NewsPlace(), false, false);
			tiles.add(newsTile);
			
			// Processes Tile
			Tile processTile = new Tile("fa-ellipsis-v fa-3x", "Prozesse", new StudentPlace(), false, true);
			
			// showcase update
			LayoutPanel updatePanel = new LayoutPanel();
			updatePanel.getElement().getStyle().setPaddingTop(25, Unit.PX);
			updatePanel.getElement().getStyle().setProperty("display", "table-cell");
			updatePanel.getElement().getStyle().setProperty("verticalAlign", "middle");
			updatePanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			
			Label updateLabel = new Label();
			updateLabel.setText("Seminar updates:\n 2");
			updateLabel.setWidth("70px");
			
			// font style
			updateLabel.getElement().getStyle().setFontSize(12, Unit.PX);
			updateLabel.getElement().getStyle().setProperty("fontFamily", "HelveticaNeue, consolas");
			updateLabel.getElement().getStyle().setColor("#FFFFFF");
			
			// setup margin titlebox
			updateLabel.getElement().getStyle().setMarginLeft(5, Unit.PX);
			updateLabel.getElement().getStyle().setMarginRight(5, Unit.PX);
			updateLabel.getElement().getStyle().setLineHeight(12, Unit.PX);
			
			updatePanel.add(updateLabel);
			
			processTile.update(2, updatePanel);
			tiles.add(processTile);
			
			// Lecture Tile
			Tile lectureTile = new Tile("fa-comments-o fa-3x", "Vorlesung", new LecturePlace(), false, false);
			tiles.add(lectureTile);
		
			// Mensa Tile
			Tile mensaTile = new Tile("fa-cutlery fa-3x", "Mensa", new MensaPlace(), false, false);
			tiles.add(mensaTile);
			
			// Settings Tile
			Tile settingsTile = new Tile("fa-gears fa-3x", "Einstellungen", new SettingsPlace(), false, false);
			tiles.add(settingsTile);
			
			// store them
			storeTiles();
		}
	}
	
	/**
	 * Get current Tiles on Tileboard
	 * @return
	 */
	public static List<Tile> getTiles() {
		if (tiles == null) tiles = new ArrayList<Tile>();
		return tiles;
	}
	
	/**
	 * Add tile to Tileboard.
	 * @param newTile
	 */
	public static void addTile(Tile newTile) {
		if (tiles == null) tiles = new ArrayList<Tile>();
		tiles.add(newTile);
		
		storeTiles();
	}
	
	/**
	 * Stores HomeSreenTiles into local storage.
	 */
	private static void storeTiles() {
		stockStore = Storage.getLocalStorageIfSupported();
		
		if (stockStore != null) {
			String homeScreenTilesJSON = "[";
		
			for (Tile tile : tiles) {
				homeScreenTilesJSON += tile.toJSON() + ", ";
			}
			
			// remove last ','
			homeScreenTilesJSON = homeScreenTilesJSON.substring(0, homeScreenTilesJSON.length() - 2);
			homeScreenTilesJSON += "]";
			
			stockStore.setItem(StorageKey.HomeScreenTiles.toString(), homeScreenTilesJSON);
		}
	}
	
}
