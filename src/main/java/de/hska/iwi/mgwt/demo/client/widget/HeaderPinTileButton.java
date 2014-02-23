package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;

/**
 * Implements header button, which pins a given place to the home screen in form of
 * a tile.
 * @author Martin
 *
 */
public class HeaderPinTileButton implements IsWidget {

	TapHandler handler;
	boolean isPinned;
	Place targetPlace;
	
	/**
	 * Public constructor, setting up TapHandler and target place.
	 * @param handler
	 */
	public HeaderPinTileButton(TapHandler handler, Place targetPlace) {
		this.handler = handler;
		this.targetPlace = targetPlace;
	}
	
	@Override
	public Widget asWidget() {
		HeaderButton pinTileButton = new CustomHeaderButton();
		pinTileButton.setRoundButton(true);

		// use font-awesome icon
		pinTileButton.setText("<i class='fa fa-thumb-tack fa-lg'></i>");

		// handle history back
		pinTileButton.addTapHandler(this.handler);
		
		return pinTileButton;
	}

	/**
	 * Getter for isPinned (on home screen).
	 * @return Boolean isPinned
	 */
	public boolean isPinned() {
		return TileBoardManager.isTilePinned(this.targetPlace);
	}

	
	/**
	 * Setter for isPinned (on home screen).
	 * @param isPinned
	 */
	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}
	

}
