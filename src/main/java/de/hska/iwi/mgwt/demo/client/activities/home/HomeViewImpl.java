package de.hska.iwi.mgwt.demo.client.activities.home;

import java.util.ArrayList;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
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
	
	public HomeViewImpl() {
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
		TileBoard tileBoard = new TileBoard();
		
		// Add tiles to the TileBoard
		if (TileBoardManager.getTiles().size() > 0) {
			tileBoard.addAll(TileBoardManager.getTiles());
		} else {
			Dialogs.alert("no Tiles", "", null);
		}

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

}
