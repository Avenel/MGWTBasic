package de.hska.iwi.mgwt.demo.client.activities.home;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.client.widget.NavigationBar;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
import de.hska.iwi.mgwt.demo.client.widget.TileBoard;
import de.hska.iwi.mgwt.demo.events.PageName;

/**
 * Implements a simple Home view. Showing HSKA Title and HomeTiles.
 * @author Martin
 *
 */
public class HomeViewImpl implements HomeView{

	private LayoutPanel main;
	private Button newsButton;
	private Button studentButton;
	private Button lectureButton;
	private NavigationBar navigation;
	
	private ArrayList<Tile> tiles;
	
	public HomeViewImpl() {
		this.tiles = new ArrayList<Tile>();
	}

	@Override
	public Widget asWidget() {
		main = new LayoutPanel();
		
		// Header
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("HS Karlsruhe IWII");
		
		main.add(headerPanel);
		
		// TileBoard embedded in a ScrollPanel
		ScrollPanel scrollPanel = new ScrollPanel();
		
		// Setup Tiles
		TileBoard tileBoard = new TileBoard();
		this.tiles = new ArrayList<Tile>();
		
		Tile newsTile = new Tile("assets/icons/WebNews.png", "Aktuelles", PageName.HOME);
		tileBoard.add(newsTile);
		this.tiles.add(newsTile);
		
		Tile processTile = new Tile("assets/icons/Process.png", "Prozesse", PageName.PROCESSES_MAIN);
		tileBoard.add(processTile);
		this.tiles.add(processTile);
		
		Tile lectureTile = new Tile("assets/icons/UniHut.png", "Vorlesung", PageName.LECTURE_MAIN);
		tileBoard.add(lectureTile);
		this.tiles.add(lectureTile);
	
		Tile mensaTile = new Tile("assets/icons/MensaWhite.png", "Mensa", PageName.MENSA_MAIN);
		tileBoard.add(mensaTile);
		this.tiles.add(mensaTile);

		scrollPanel.add(tileBoard.asWidget());
		main.add(scrollPanel);

		return this.main;
	}

	@Override
	public Button getNewsButton() {
		return this.newsButton;
	}

	@Override
	public Button getStudentButton() {
		return this.studentButton;
	}

	@Override
	public Button getLectureButton() {
		return this.lectureButton;
	}

	@Override
	public NavigationBar getNavigation() {
		return navigation;
	}

	@Override
	public ArrayList<Tile> getTiles() {
		return this.tiles;
	}

}
