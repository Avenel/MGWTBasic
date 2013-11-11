package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.activities.news.NewsCell;
import de.hska.iwi.mgwt.demo.client.model.News;

/**
 * Represents a simple list to navigate through app-content.
 * @author Martin
 *
 */
public class NavigationBar implements IsWidget {

	private CellList<MenueItem> cellList;
	private List<MenueItem> menueItems;

	public NavigationBar(List<MenueItem> menueItems) {
		this.menueItems = menueItems;
	}
	
	@Override
	public Widget asWidget() {
		cellList = new CellList<MenueItem>(new MenueItemCell());
		cellList.render(this.menueItems);
		
		ScrollPanel panel = new ScrollPanel();
		panel.add(cellList);
			
		return panel;
	}

	public HandlerRegistration addCellSelectedHandler(
			CellSelectedHandler cellSelectedHandler) {
		return this.cellList.addCellSelectedHandler(cellSelectedHandler);
	}

}
