package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.FavoritesTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.MostViewedTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class NewsViewImpl implements NewsView {

	private LayoutPanel main;
	private CellList<News> cellListIM;
	private CellList<News> cellListIB;
	private CellList<News> cellListIWI;
	private CellList<News> cellListFAK;

	public NewsViewImpl() {
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Schwarzes Brett");
		main.add(headerPanel);
	
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		// Create 4 different cellists for each organisation
		this.cellListFAK = new CellList<News>(new NewsCell());
		ScrollPanel panelFAK = new ScrollPanel();
		panelFAK.add(cellListFAK);
		
		this.cellListIM = new CellList<News>(new NewsCell());
		ScrollPanel panelIM = new ScrollPanel();
		panelIM.add(cellListIM);
		
		this.cellListIB = new CellList<News>(new NewsCell());
		ScrollPanel panelIB = new ScrollPanel();
		panelIB.add(cellListIB);
		
		this.cellListIWI = new CellList<News>(new NewsCell());
		ScrollPanel panelIWI = new ScrollPanel();
		panelIWI.add(cellListIWI);
		
		// create TabBar
		TabPanel tabPanel = new TabPanel();
		
		TabBarButton tabBarButtonAktuellesFAK = new MostViewedTabBarButton();
		tabBarButtonAktuellesFAK.setText("IWII");
		TabBarButton tabBarButtonAktuellesIM = new MostViewedTabBarButton();
		tabBarButtonAktuellesIM.setText("IM");
		TabBarButton tabBarButtonAktuellesIB = new FavoritesTabBarButton();
		tabBarButtonAktuellesIB.setText("IB");
		TabBarButton tabBarButtonAktuellesIWI = new HistoryTabBarButton();
		tabBarButtonAktuellesIWI.setText("WI");
		
		tabPanel.add(tabBarButtonAktuellesFAK, panelFAK);
		tabPanel.add(tabBarButtonAktuellesIM, panelIM);
		tabPanel.add(tabBarButtonAktuellesIB, panelIB);
		tabPanel.add(tabBarButtonAktuellesIWI, panelIWI);
		
		main.add(tabPanel);
	}
	
	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void render(List<News> newsList) {
		List<News> newsListIM = new ArrayList<News>();
		List<News> newsListIB = new ArrayList<News>();
		List<News> newsListIWI = new ArrayList<News>();
		
		for (News news : newsList) {
			if (news.getOrganisation().equals("[IM]")) {
				newsListIM.add(news);
			}
			if (news.getOrganisation().equals("[IB]")) {
				newsListIB.add(news);
			}
			if (news.getOrganisation().equals("[IWI]")) {
				newsListIWI.add(news);
			}
		}
		
		this.cellListIM.render(newsListIM);
		this.cellListIB.render(newsListIB);	
		this.cellListIWI.render(newsListIWI);	
		this.cellListFAK.render(newsListIWI);
	}

	@Override
	public HasCellSelectedHandler getListIM() {
		return this.cellListIM;
	}

	@Override
	public HasCellSelectedHandler getListIB() {
		return this.cellListIB;
	}

	@Override
	public HasCellSelectedHandler getListIWI() {
		return this.cellListIWI;
	}
	
	@Override
	public HasCellSelectedHandler getListFAK() {
		return this.cellListIWI;
	}

	@Override
	public CellList<News> getCellListIM() {
		return this.cellListIM;
	}

	@Override
	public CellList<News> getCellListIB() {
		return this.cellListIB;
	}

	@Override
	public CellList<News> getCellListIWI() {
		return this.cellListIWI;
	}

	@Override
	public CellList<News> getCellListFAK() {
		return this.cellListFAK;
	}
	
	


}
