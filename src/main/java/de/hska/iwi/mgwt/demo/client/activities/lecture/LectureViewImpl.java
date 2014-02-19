package de.hska.iwi.mgwt.demo.client.activities.lecture;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

/**
 * Implementation of LectureView.
 * @author Martin
 *
 */
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
