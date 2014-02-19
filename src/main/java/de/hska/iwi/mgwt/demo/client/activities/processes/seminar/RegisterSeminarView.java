package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.Button;

public interface RegisterSeminarView extends IsWidget {

	public void render();
	public Button getRegisterButton();
	public List<String> getInputs();
}
