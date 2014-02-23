package de.hska.iwi.mgwt.demo.client.activities.settings;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

/**
 * Interface for settings view. 
 * @author Martin
 *
 */
public interface SettingsView extends IsWidget {
	
	/**
	 * Setter for setting item widgets, the view has to display.
	 * @param settingItems
	 * @param newTitle
	 */
	public void setSettingItems(List<Widget> settingItems, String newTitle);
	
	/**
	 * Getter for scrollpanel. FYI: the accordion has to know its parent scrollpanel, if one exists.
	 * @return ScrollPanel scrollPanel
	 */
	public ScrollPanel getWrapperScrollPanel();

}
