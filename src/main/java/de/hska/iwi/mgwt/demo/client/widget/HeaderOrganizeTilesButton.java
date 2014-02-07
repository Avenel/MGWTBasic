package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class HeaderOrganizeTilesButton implements IsWidget {
	
private HeaderButton organizeButton;
private TapHandler handler;

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

}
