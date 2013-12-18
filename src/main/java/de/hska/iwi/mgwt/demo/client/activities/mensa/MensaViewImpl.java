package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class MensaViewImpl implements MensaView {

	private LayoutPanel main;

	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Mensa");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		
		return this.main;
	}

}
