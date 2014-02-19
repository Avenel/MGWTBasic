package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;

/**
 * Interface for mensa view.
 * @author Martin
 *
 */
public interface MensaView extends IsWidget {

	/**
	 * Setter for a received mensa menu.
	 * @param mensaMenus
	 */
	public void setMensaMenu(MensaMenu mensaMenus);
	
	/**
	 * Setter for the amount of days.
	 * @param maxDays
	 */
	public void setMaxMenuDays(int maxDays);
	
	/**
	 * Adds a TapHandler to the SettingsButton.
	 * @param handler
	 */
	public void addTapHandlerToSettingsButton(TapHandler handler);
}
