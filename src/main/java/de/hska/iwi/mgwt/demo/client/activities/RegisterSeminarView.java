package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

public interface RegisterSeminarView extends IsWidget {

	public void addContentToRootTabPanel (RootTabPanel rtp);
	public void render();
	public Button getRegisterButton();
}
