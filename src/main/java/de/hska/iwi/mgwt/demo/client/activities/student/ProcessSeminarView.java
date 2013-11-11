package de.hska.iwi.mgwt.demo.client.activities.student;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;

import de.hska.iwi.mgwt.demo.client.model.Seminar;

public interface ProcessSeminarView extends IsWidget {

	public void render(List<Seminar> seminarList);
	public Button getRegisterButton();
}
