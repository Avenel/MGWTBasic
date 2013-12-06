package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderSettingsButton;

public class NewsViewImpl implements NewsView {

	private LayoutPanel main;
	private CellList<News> cellListNews;
	private HeaderSettingsButton settingsButton;
	

	public NewsViewImpl() {
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Schwarzes Brett");
		main.add(headerPanel);
	
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		settingsButton = new HeaderSettingsButton();
		headerPanel.setRightWidget(settingsButton.asWidget());
		
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
