package de.hska.iwi.mgwt.demo.client.activities.settings;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.model.InputType;
import de.hska.iwi.mgwt.demo.client.model.SettingItem;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;
import de.hska.iwi.mgwt.demo.client.widget.CheckBoxWidget;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.SettingItemMenuLink;
import de.hska.iwi.mgwt.demo.client.widget.TextInputWidget;

public class SettingsViewImpl implements SettingsView {
	private LayoutPanel main;
	
	public SettingsViewImpl() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("App-Einstellungen");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		WidgetList widgetList = new WidgetList();
	    widgetList.setRound(true);
	    
	    for (SettingItem item : SettingStorage.getSettingItems()) {
	    	if (item.getInputType().equals(InputType.MENUELINK)) {
	    		widgetList.add(new SettingItemMenuLink(item.getKey().getHumanReadableName(), item.getFontAwesomeIcom()).asWidget());
	    	}
	    	
	    	if (item.getInputType().equals(InputType.TEXT)) {
	    		widgetList.add(new TextInputWidget(item.getKey().getHumanReadableName(), StorageKey.IZAccountname).asWidget());
	    	}
	    	
	    	if (item.getInputType().equals(InputType.CHECKBOX)) {
	    		widgetList.add(new CheckBoxWidget(item.getKey().getHumanReadableName(), StorageKey.IsSendingPushMessages).asWidget());
	    	}
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
