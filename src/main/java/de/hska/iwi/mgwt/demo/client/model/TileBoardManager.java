package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentPlace;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
import de.hska.iwi.mgwt.demo.client.widget.TileBoard;
import de.hska.iwi.mgwt.demo.events.PageName;

/**
 * Manages tiles on TileBoard. In future it can load tiles, stored in files on the clientside.
 * @author Martin
 *
 */
public class TileBoardManager {

	static List<Tile> tiles;
	
	/**
	 * Bootstrap, add necessary tiles.
	 */
	public static void initTiles() {		
		tiles = new ArrayList<Tile>();
		
		// News Tile
		Tile newsTile = new Tile("assets/icons/WebNews.png", "Aktuelles", new NewsPlace(), false);
		tiles.add(newsTile);
		
		// Processes Tile
		Tile processTile = new Tile("assets/icons/Process.png", "Prozesse", new StudentPlace(), false);
		
		// TODO showcase update
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
		Tile lectureTile = new Tile("assets/icons/UniHut.png", "Vorlesung", new LecturePlace(), false);
		tiles.add(lectureTile);
	
		// Mensa Tile
		Tile mensaTile = new Tile("assets/icons/MensaWhite.png", "Mensa", new HomePlace(), false);
		tiles.add(mensaTile);
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
	}
	
}
