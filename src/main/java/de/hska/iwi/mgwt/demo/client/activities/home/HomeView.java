package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;

import de.hska.iwi.mgwt.demo.client.widget.NavigationBar;

public interface HomeView extends IsWidget {
	
	public Button getNewsButton();
	public Button getStudentButton();
	public Button getLectureButton();
	public NavigationBar getNavigation();
	
}
