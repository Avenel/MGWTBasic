package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class HeaderPinTileButton implements IsWidget {

	TapHandler handler;
	
	/**
	 * Public constructor.
	 * @param handler
	 */
	public HeaderPinTileButton(TapHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public Widget asWidget() {
		HeaderButton pinTileButton = new HeaderButton();
		pinTileButton.setRoundButton(true);
		pinTileButton.setText("Pin");

		// handle history back
		pinTileButton.addTapHandler(this.handler);
		
		return pinTileButton;
	}
	

}
