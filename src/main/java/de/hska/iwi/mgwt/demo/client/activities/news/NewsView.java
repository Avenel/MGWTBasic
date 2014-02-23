package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.backend.model.News;

/**
 * Interface for news view.
 * @author Martin
 *
 */
public interface NewsView extends IsWidget {
	
	/**
	 * Renders cell-list with given content.
	 * @param newsList
	 */
	public void render(List<News> newsList);
	
	/**
	 * Returns CellSelectHandler of cell-list..
	 * @return HasCellSelectedHandler handler
	 */
	public HasCellSelectedHandler getListNews();
	
	/**
	 * Returns cell-list.
	 * @return CellList<News> cell-list
	 */
	public CellList<News> getCellListNews();
	
	/**
	 * Add tap handler to settings button.
	 * @param handler
	 */
	public void addTapHandlerToSettingsButton(TapHandler handler);
}
