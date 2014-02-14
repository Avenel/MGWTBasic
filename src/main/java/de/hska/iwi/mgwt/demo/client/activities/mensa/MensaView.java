package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;


public interface MensaView extends IsWidget {

	public void setMensaMenu(MensaMenu mensaMenus);
	public void setMaxMenuDays(int maxDays);
	public void addTapHandlerToSettingsButton(TapHandler handler);
}
