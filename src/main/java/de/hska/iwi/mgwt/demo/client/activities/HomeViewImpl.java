package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.FavoritesTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.FeaturedTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

import de.hska.iwi.mgwt.demo.client.model.News;

public class HomeViewImpl implements HomeView {

	private LayoutPanel main;
	private CellList<News> cellist;

	public HomeViewImpl() {
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Schwarzes Brett");
		main.add(headerPanel);
		
		this.cellist = new CellList<News>(new NewsCell());
		main.add(this.cellist);
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.add(new FeaturedTabBarButton(), new Label("Aktuelles"));
		tabPanel.add(new FavoritesTabBarButton(), new Label("Student"));
		tabPanel.add(new HistoryTabBarButton(), new Label("Vorlesung"));
		main.add(tabPanel);
	}
	
	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void render(List<News> newsList) {
		this.cellist.render(newsList);	
	}

	@Override
	public HasCellSelectedHandler getList() {
		return this.cellist;
	}

}
