package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.model.News;

public interface HomeView extends IsWidget {
	
	public void render(List<News> newsList);
	public HasCellSelectedHandler getList();
	public void addContentToRootTabPanel (RootTabPanel rtp);
}
