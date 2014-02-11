package de.hska.iwi.mgwt.demo.client.activities.settings;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.model.InputType;
import de.hska.iwi.mgwt.demo.client.model.SettingItem;
import de.hska.iwi.mgwt.demo.client.model.SettingItemMenueImpl;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.widget.CheckBoxWidget;
import de.hska.iwi.mgwt.demo.client.widget.SettingItemMenuLink;
import de.hska.iwi.mgwt.demo.client.widget.TextInputWidget;

public class SettingsActivity extends MGWTAbstractActivity {
	
	private final ClientFactory clientFactory;
	private final String id;

	public SettingsActivity(ClientFactory clientFactory, String id) {
		this.clientFactory = clientFactory;
		this.id = id;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		List<Widget> settingItemWidgets = new ArrayList<Widget>();
		
		System.out.println(id);
		
		for (SettingItem item : SettingStorage.getSettingItems(SettingMenueName.getKey(id))) {
	    	if (item.getInputType().equals(InputType.MENUELINK)) {
	    		settingItemWidgets.add(new SettingItemMenuLink(item.getFontAwesomeIcon(), SettingMenueName.getKey(item.getValue()), 
	    									((SettingItemMenueImpl) item).getHandler(clientFactory)).asWidget());
	    	}
	    	
	    	if (item.getInputType().equals(InputType.TEXT)) {
	    		settingItemWidgets.add(new TextInputWidget(item.getStorageKey().getHumanReadableName(), item.getStorageKey()).asWidget());
	    	}
	    	
	    	if (item.getInputType().equals(InputType.CHECKBOX)) {
	    		settingItemWidgets.add(new CheckBoxWidget(item.getStorageKey().getHumanReadableName(), item.getStorageKey()).asWidget());
	    	}
	    }
		
		System.out.println(settingItemWidgets.size());
		SettingsView view = this.clientFactory.getSettingsView(settingItemWidgets);
		
		panel.setWidget(view);
	}
	
}
