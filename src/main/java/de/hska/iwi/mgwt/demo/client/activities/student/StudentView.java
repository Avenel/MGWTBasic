package de.hska.iwi.mgwt.demo.client.activities.student;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.model.MenuItem;

public interface StudentView extends IsWidget {
	public void render(List<MenuItem> menuItems);
	public HasCellSelectedHandler getMenuItemsListRegister();
	public HasCellSelectedHandler getMenuItemsListManage();
}
