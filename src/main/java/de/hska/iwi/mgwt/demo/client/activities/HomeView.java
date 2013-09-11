package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.model.News;

public interface HomeView extends IsWidget {
	
	public void render(List<News> newsList);
	public HasCellSelectedHandler getListIM();
	public HasCellSelectedHandler getListIB();
	public HasCellSelectedHandler getListIWI();
	public void addContentToRootTabPanel (RootTabPanel rtp);
	public CellList<News> getCellListIM();
	public CellList<News> getCellListIB();
	public CellList<News> getCellListIWI();
}
