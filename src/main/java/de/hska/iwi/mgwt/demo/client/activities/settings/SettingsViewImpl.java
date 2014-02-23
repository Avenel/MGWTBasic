package de.hska.iwi.mgwt.demo.client.activities.settings;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

/**
 * Implements settings view interface. Displays given setting item widget in a
 * widgetlist.
 * @author Martin
 *
 */
public class SettingsViewImpl implements SettingsView {
	private LayoutPanel main;
	private List<Widget> settingItems;
	private ScrollPanel panelSettings;
	private HeaderPanel headerPanel;
	private String title;
	
	/**
	 * Public constructor. Setting up scrollpanel, headerpanel and setting item widget list.
	 */
	public SettingsViewImpl() {
		this.settingItems = new ArrayList<Widget>();
		panelSettings = new ScrollPanel();
		headerPanel = new HeaderPanel();
	}
	
	/**
	 * Setter for setting items and setting title.
	 * @param List<Widget> settingItems
	 * @param String newTitle
	 */
	public void setSettingItems(List<Widget> settingItems, String newTitle) {
		this.settingItems = settingItems;
		this.title = newTitle;
	}
	
	/**
	 * Init Settings view, especially setting item widgetlist.
	 * @param settingItems
	 */
	private void init(List<Widget> settingItems) {
		this.main = new LayoutPanel();
		
		headerPanel.setCenter(this.title);
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		WidgetList widgetList = new WidgetList();
	    widgetList.setRound(true);
	    widgetList.getElement().addClassName("mgwt-List-settings");
	    
	    for (Widget item : settingItems) {
	    	widgetList.add(item);
	    }
		
	    panelSettings.clear();
		panelSettings.add(widgetList);

		this.main.add(panelSettings);
	}
	
	@Override
	public Widget asWidget() {	
		init(this.settingItems);
		return this.main;
	}

	@Override
	public ScrollPanel getWrapperScrollPanel() {
		return this.panelSettings;
	}

}
