package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.backend.model.News;

public interface NewsView extends IsWidget {
	
	public void render(List<News> newsList);
	public HasCellSelectedHandler getListNews();
	public CellList<News> getCellListNews();
	public void addTapHandlerToSettingsButton(TapHandler handler);
}
