package de.hska.iwi.mgwt.demo.client.activities.lecture;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class LectureViewImpl implements LectureView {

	private LayoutPanel main;
	
	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Vorlesung");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		return this.main;
	}


}
