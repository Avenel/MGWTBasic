package de.hska.iwi.mgwt.demo.client.activities.processes;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

public interface ProcessDetailView extends IsWidget {

	public Button getRegisterButton();
	public void setTitle(String title);
	public void render();
	public void render(List<ProcessStep> steps);
}
