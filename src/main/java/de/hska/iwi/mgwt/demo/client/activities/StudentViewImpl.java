package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

public class StudentViewImpl implements StudentView {

	private LayoutPanel main;
	
	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Student");
		this.main.add(headerPanel);
		
		return this.main;
	}

	@Override
	public void addContentToRootTabPanel(RootTabPanel rtp) {
		rtp.getAnimatableDisplay().setFirstWidget(this.main);
	}

}
