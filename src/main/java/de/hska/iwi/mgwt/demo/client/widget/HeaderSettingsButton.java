package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class HeaderSettingsButton implements IsWidget {
		
	private HeaderButton settingsButton;
	private TapHandler handler;

	public HeaderSettingsButton() {
		settingsButton = new CustomHeaderButton();
		settingsButton.setRoundButton(true);
		settingsButton.setText("<i class='fa fa-cog fa-lg'></i>");
	}
	
	
	@Override
	public Widget asWidget() {		
		return settingsButton;
	}
	
	/**
	 * Set tap handler in order to get to the settings place.
	 * @param handler
	 */
	public void setTapHandler(TapHandler handler) {
		if (this.handler == null) {
			this.handler = handler;
			settingsButton.addTapHandler(handler);
		}
	}

}
