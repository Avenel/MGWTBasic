package de.hska.iwi.mgwt.demo.client.activities.processes;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;

public interface ProcessDetailView extends IsWidget {

	public Button getRegisterButton();
	public void setTitle(String title);
	public void render();
}
