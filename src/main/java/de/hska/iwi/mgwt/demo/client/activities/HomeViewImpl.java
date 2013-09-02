package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationEndCallback;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.MostViewedTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;

import de.hska.iwi.mgwt.demo.client.model.News;

public class HomeViewImpl implements HomeView {

	private LayoutPanel main;
	private CellList<News> cellList;

	public HomeViewImpl() {
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Schwarzes Brett");
		main.add(headerPanel);
		
		this.cellList = new CellList<News>(new NewsCell());
		main.add(cellList);
	}
	
	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public void render(List<News> newsList) {
		this.cellList.render(newsList);	
	}

	@Override
	public HasCellSelectedHandler getList() {
		return this.cellList;
	}

	@Override
	public void addContentToRootTabPanel(RootTabPanel rtp) {
		rtp.getAnimatableDisplay().setFirstWidget(main);
	}

}
