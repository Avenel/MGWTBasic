package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ProgressBar;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderSettingsButton;

/**
 * Implementation of news view interface. Displays a cell-list with the user filtered news-items in it.
 * @author Martin
 *
 */
public class NewsViewImpl implements NewsView {

	private LayoutPanel main;
	private CellList<News> cellListNews;
	private HeaderSettingsButton settingsButton;
	private Label loadingLabel;
	private ProgressBar pBar;
	
	
	/**
	 * Public constructor, setting up header panel, setting button and cell-list widget.
	 */
	public NewsViewImpl() {
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Schwarzes Brett");
		main.add(headerPanel);
	
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		settingsButton = new HeaderSettingsButton();
		headerPanel.setRightWidget(settingsButton.asWidget());
		
		// add loading bar
		loadingLabel = new Label();
		loadingLabel.setText("Lade Schwarzes Brett...");
		loadingLabel.getElement().getStyle().setColor("#DB0134");
		loadingLabel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		loadingLabel.getElement().getStyle().setMarginTop(30, Unit.PCT);
		main.add(loadingLabel);
		
		pBar = new ProgressBar();
		main.add(pBar);
	
		
		// Create 4 different cellists for each organisation
		this.cellListNews = new CellList<News>(new NewsCell());

		ScrollPanel panelNews = new ScrollPanel();
		panelNews.add(cellListNews);

		main.add(panelNews);
	}
	
	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void render(List<News> newsList) {
			this.loadingLabel.setVisible(false);
			this.pBar.setVisible(false);
			this.cellListNews.render(newsList);
	}


	@Override
	public HasCellSelectedHandler getListNews() {
		return this.cellListNews;
	}

	@Override
	public CellList<News> getCellListNews() {
		return this.cellListNews;
	}

	@Override
	public void addTapHandlerToSettingsButton(TapHandler handler) {
		this.settingsButton.setTapHandler(handler);
	}

}
