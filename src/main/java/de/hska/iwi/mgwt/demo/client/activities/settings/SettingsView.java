package de.hska.iwi.mgwt.demo.client.activities.settings;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface SettingsView extends IsWidget {
	
	public void setSettingItems(List<Widget> settingItems);

}
