package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class HeaderPinTileButton implements IsWidget {

	TapHandler handler;
	boolean isPinned;
	
	/**
	 * Public constructor.
	 * @param handler
	 */
	public HeaderPinTileButton(TapHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public Widget asWidget() {
		HeaderButton pinTileButton = new CustomHeaderButton();
		pinTileButton.setRoundButton(true);
		pinTileButton.setText("<i class='fa fa-link fa-lg'></i>");

		// handle history back
		pinTileButton.addTapHandler(this.handler);
		
		return pinTileButton;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}
	

}
