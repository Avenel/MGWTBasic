package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.events.ChangePage;

public class HomeViewImpl implements HomeView{

	private LayoutPanel main;
	private Button newsButton;
	private Button studentButton;
	private Button lectureButton;

	@Override
	public Widget asWidget() {
		
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Hochschule Karlsruhe - IWII");
		main.add(headerPanel);
		
		// TODO NavigationBar in "nice" ;)
		// adding NavigationButtons
		newsButton = new Button();
		newsButton.setTitle("Aktuelles");
		newsButton.setText("Aktuelles");
		
		main.add(newsButton);
		
		studentButton = new Button();
		studentButton.setTitle("Prozesse");
		studentButton.setText("Prozesse");
		
		main.add(studentButton);
		
		lectureButton = new Button();
		lectureButton.setTitle("Vorlesungen");
		lectureButton.setText("Vorlesungen");
		
		main.add(lectureButton);
		
		return this.main;
	}

	@Override
	public Button getNewsButton() {
		return this.newsButton;
	}

	@Override
	public Button getStudentButton() {
		return this.studentButton;
	}

	@Override
	public Button getLectureButton() {
		return this.lectureButton;
	}

}
