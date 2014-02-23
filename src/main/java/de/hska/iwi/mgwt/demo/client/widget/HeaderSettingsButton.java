package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

/**
 * Implements a header button in the upper right corner, which points to a settings menu.
 * @author Martin
 *
 */
public class HeaderSettingsButton implements IsWidget {
		
	private HeaderButton settingsButton;
	private TapHandler handler;

	/**
	 * Public constructor, setting up a custom header button with a font awesome
	 * icon (gear wheels - cogs).
	 */
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
