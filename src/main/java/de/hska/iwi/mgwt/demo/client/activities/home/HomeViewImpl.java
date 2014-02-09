package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.widget.HeaderOrganizeTilesButton;
import de.hska.iwi.mgwt.demo.client.widget.NavigationBar;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
import de.hska.iwi.mgwt.demo.client.widget.TileBoard;

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
	private HeaderOrganizeTilesButton organizeTilesButton;
	private TileBoard tileBoard;
	
	public HomeViewImpl() {
	}

	@Override
	public Widget asWidget() {
		main = new LayoutPanel();
		
		// Header
		final HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("HS Karlsruhe IWII");
		
		// add "unpin" button
		organizeTilesButton = new HeaderOrganizeTilesButton();
		organizeTilesButton.setTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				TileBoardManager.switchIsOrganizing();
				Dialogs.alert("Organisieren", (TileBoardManager.isOrganizing())? "Organisiere nun deine Tiles!" : "Organisieren beendet.", null);
				
				// let'em shake :D
				if (TileBoardManager.isOrganizing()) {
					for (Tile tile : TileBoardManager.getTiles()) {
						if (tile.isCustomLink()) {
							tile.switchShake(true);
						}
					}
				}
				
				if (!TileBoardManager.isOrganizing()) {
					for (Tile tile : TileBoardManager.getTiles()) {
						if (tile.isCustomLink()) {
							tile.switchShake(false);
						}
					}
					TileBoardManager.refreshHomeScreen(tileBoard);
				}
			}
		});
		
		headerPanel.setRightWidget(organizeTilesButton.asWidget());
		
		main.add(headerPanel);
		
		Carousel carousel = new Carousel();
		
		// TileBoard embedded in a ScrollPanel
		ScrollPanel scrollPanel = new ScrollPanel();
		tileBoard = new TileBoard();
		
		// Add tiles to the TileBoard
		if (TileBoardManager.getTiles().size() > 0) {
			tileBoard.addAll(TileBoardManager.getTiles());
		} else {
			Dialogs.alert("no Tiles", "", null);
		}

		scrollPanel.add(tileBoard.asWidget());
		carousel.add(scrollPanel);

		// Search Bar
		ScrollPanel scrollPanelSearch = new ScrollPanel();
		scrollPanelSearch.add(new MSearchBox());
		carousel.add(scrollPanelSearch);
		
		this.main.add(carousel);
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
	public TileBoard getTileBoard() {
		return this.tileBoard;
	}

}
