package de.hska.iwi.mgwt.demo.client.activities.home;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.widget.MenueItem;
import de.hska.iwi.mgwt.demo.client.widget.NavigationBar;
import de.hska.iwi.mgwt.demo.events.ChangePage;

/**
 * Implements a simple Home view. Showing HSKA Title and a navigation bar.
 * @author Martin
 *
 */
public class HomeViewImpl implements HomeView{

	private LayoutPanel main;
	private Button newsButton;
	private Button studentButton;
	private Button lectureButton;
	private NavigationBar navigation;

	@Override
	public Widget asWidget() {
		
		main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("HSKA - IWII");
		main.add(headerPanel);
		
		// "nice" navigationbar
		ArrayList<MenueItem> menueItems = new ArrayList<MenueItem>();
		menueItems.add(new MenueItem("Aktuelles", "assets/icons/WebNews.png"));
		menueItems.add(new MenueItem("Prozesse", "assets/icons/Process.png"));
		menueItems.add(new MenueItem("Vorlesungen", "assets/icons/UniHut.png"));
		
		navigation = new NavigationBar(menueItems);
		main.add(navigation.asWidget());
		
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

	@Override
	public NavigationBar getNavigation() {
		return navigation;
	}

}
