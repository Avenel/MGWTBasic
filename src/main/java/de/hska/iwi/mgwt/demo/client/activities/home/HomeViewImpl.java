package de.hska.iwi.mgwt.demo.client.activities.home;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.client.widget.MenueItem;
import de.hska.iwi.mgwt.demo.client.widget.NavigationBar;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
import de.hska.iwi.mgwt.demo.client.widget.TileBoard;
import de.hska.iwi.mgwt.demo.events.ChangePage;

/**
 * Implements a simple Home view. Showing HSKA Title and a navigation bar.
 * @author Martin
 *
 */
public class HomeViewImpl implements HomeView{

	private LayoutPanel main;
	private Button newsButton;
	private Button studentButton;
	private Button lectureButton;
	private NavigationBar navigation;

	@Override
	public Widget asWidget() {
		main = new LayoutPanel();
		
		// Header
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("HSKA - IWII");
		
		main.add(headerPanel);
		
		// Caroussel wraps all
		Carousel carousel = new Carousel();
		
		// TileBoard embedded in a ScrollPanel
		ScrollPanel scrollPanel = new ScrollPanel();
		
		// Setup Tiles
		TileBoard tileBoard = new TileBoard();
		
		Tile newsTile = new Tile("assets/icons/WebNews.png", "Aktuelles", "#EDEDED");
		
		tileBoard.add(newsTile);
		
		Tile processTile = new Tile("assets/icons/Process.png", "Prozesse", "#EDEDED");
		tileBoard.add(processTile);
		
		Tile lectureTile = new Tile("assets/icons/UniHut.png", "Vorlesung", "#EDEDED");
		tileBoard.add(lectureTile);
	
		Tile mensaTile = new Tile("assets/icons/MensaWhite.png", "Mensa", "#EDEDED");
		tileBoard.add(mensaTile);

		scrollPanel.add(tileBoard.asWidget());
		carousel.add(scrollPanel);

		
		// Simple Navigation List
		ArrayList<MenueItem> menueItems = new ArrayList<MenueItem>();
		menueItems.add(new MenueItem("Aktuelles", "assets/icons/WebNews.png"));
		menueItems.add(new MenueItem("Prozesse", "assets/icons/Process.png"));
		menueItems.add(new MenueItem("Vorlesungen", "assets/icons/UniHut.png"));
		
		navigation = new NavigationBar(menueItems);
		carousel.add(navigation.asWidget());
		
		// adding carousel
		main.add(carousel);
		
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

}
