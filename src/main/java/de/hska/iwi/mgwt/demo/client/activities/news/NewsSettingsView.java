package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.user.client.ui.IsWidget;

import de.hska.iwi.mgwt.demo.client.widget.CheckBoxWidget;

public interface NewsSettingsView extends IsWidget {

	public CheckBoxWidget getIWIFilterCheckBox();
	public CheckBoxWidget getIMFilterCheckBox();
	public CheckBoxWidget getIBFilterCheckBox();
	public CheckBoxWidget getMKIFilterCheckBox();
	
}
