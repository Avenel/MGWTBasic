package de.hska.iwi.mgwt.demo.client.activities.processes;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.model.MenuItem;
/**
 * Interface for StudentView, a view that represents the StudentActivity
 * @author Simon
 *
 */
public interface StudentView extends IsWidget {
	/**
	 * renders all relevant elements and refreshes them.
	 * @param menuItems The menuItems available for the user
	 */
	public void render(List<MenuItem> menuItems);
	/**
	 * Gets the Items for a Process-Register Menu
	 * @return
	 */
	public HasCellSelectedHandler getMenuItemsListRegister();
	
	/**
	 * Gets the Items for a Process-Manage Menu
	 * @return
	 */
	public HasCellSelectedHandler getMenuItemsListManage();
}
