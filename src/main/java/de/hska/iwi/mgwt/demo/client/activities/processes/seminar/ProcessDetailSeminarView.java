package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;

public interface ProcessDetailSeminarView extends IsWidget {

	public Button getRegisterButton();
	public void setTitle(String title);
	public void render();
}
