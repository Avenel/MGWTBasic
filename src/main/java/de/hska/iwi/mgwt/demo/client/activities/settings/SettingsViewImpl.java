package de.hska.iwi.mgwt.demo.client.activities.settings;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class SettingsViewImpl implements SettingsView {
	private LayoutPanel main;
	
	public SettingsViewImpl(List<Widget> settingItems) {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("App-Einstellungen");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		WidgetList widgetList = new WidgetList();
	    widgetList.setRound(true);
	    
	    for (Widget item : settingItems) {
	    	widgetList.add(item);
	    }
		
		ScrollPanel panelSettings = new ScrollPanel();
		panelSettings.add(widgetList);

		this.main.add(panelSettings);
	}
	
	@Override
	public Widget asWidget() {		
		return this.main;
	}

}
