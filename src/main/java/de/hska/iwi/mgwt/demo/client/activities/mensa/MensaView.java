package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.user.client.ui.IsWidget;

import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;


public interface MensaView extends IsWidget {

//	public void setMensaMenu(List<MensaMenu> mensaMenus);
	public void setMensaMenu(MensaMenu mensaMenus);
	
}
