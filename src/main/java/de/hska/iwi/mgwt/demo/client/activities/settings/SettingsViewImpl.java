package de.hska.iwi.mgwt.demo.client.activities.settings;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class SettingsViewImpl implements SettingsView {
	private LayoutPanel main;
	private List<Widget> settingItems;
	
	public SettingsViewImpl() {
		this.settingItems = new ArrayList<Widget>();
	}
	
	public void setSettingItems(List<Widget> settingItems) {
		this.settingItems = settingItems;
	}
	
	private void init(List<Widget> settingItems) {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("App-Einstellungen");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		WidgetList widgetList = new WidgetList();
	    widgetList.setRound(true);
	    widgetList.getElement().addClassName("mgwt-List-settings");
	    
	    for (Widget item : settingItems) {
	    	widgetList.add(item);
	    }
		
		ScrollPanel panelSettings = new ScrollPanel();
		panelSettings.add(widgetList);

		this.main.add(panelSettings);
	}
	
	@Override
	public Widget asWidget() {	
		init(this.settingItems);
		return this.main;
	}

}
