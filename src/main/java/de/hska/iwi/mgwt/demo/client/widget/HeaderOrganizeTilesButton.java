package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

/**
 * Implements a HeaderButton (upper right corner) to switch the state "isOrganizing" in HomeActivity to manage 
 * the home screen tiles. 
 * @author Martin
 *
 */
public class HeaderOrganizeTilesButton implements IsWidget {
		
	private HeaderButton organizeButton;
	private TapHandler handler;

	/**
	 * Public constructor, setup a custom header button with a 
	 * font awesome icon (magic staff).
	 */
	public HeaderOrganizeTilesButton() {
		organizeButton = new CustomHeaderButton();
		organizeButton.setRoundButton(true);
		organizeButton.setText("<i class='fa fa-magic fa-lg'></i>");
	}
	
	
	@Override
	public Widget asWidget() {		
		return organizeButton;
	}
	
	/**
	 * Set tap handler in order to get to the settings place.
	 * @param handler
	 */
	public void setTapHandler(TapHandler handler) {
		if (this.handler == null) {
			this.handler = handler;
			organizeButton.addTapHandler(handler);
		}
	}
	
	/**
	 * Switches button state.
	 * @param doOrganize
	 */
	public void switchOrganize(boolean doOrganize) {
		if (doOrganize) {
			organizeButton.setText("<i class='fa fa-magic fa-lg' style='color: #DB0134'></i>");
			organizeButton.asWidget().getElement().getFirstChildElement().getNextSiblingElement().getStyle().setBackgroundColor("#FFFFFF");
		} else {
			organizeButton.setText("<i class='fa fa-magic fa-lg' style='color: #FFFFFF'></i>");
			organizeButton.asWidget().getElement().getFirstChildElement().getNextSiblingElement().getStyle().setBackgroundColor("#ED8689");
		}
	}

}
