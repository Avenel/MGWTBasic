package de.hska.iwi.mgwt.demo.client.storage;

import de.hska.iwi.mgwt.demo.client.model.HumanReadableEnum;

/**
 * This enum holds every StorageKey which are used in this app.
 * 
 * @author Martin
 * 
 */
public enum StorageKey implements HumanReadableEnum {

	NewsSettingsFilterIWI(""), NewsSettingsFilterIB(""), NewsSettingsFilterIM(""), NewsSettingsFilterMKI(""), 
	ProcessesSeminarsList(""), ProcessesSeminarProfessor(""), ProcessesSeminarTerm(""), ProcessesSeminarTopic(""), ProcessesSeminarStatus(""),
	HomeScreenTiles(""), IZAccountname("Benutzername"), IZAccountPassword("Passwort"), IZAccount("IZ Account"),
	IsSendingPushMessages("Pushbenachrichtigungen"), MENUELINK("MenueLink");
	
	private String humanReadableName;
	
	private StorageKey(String name) {
		this.humanReadableName = name;
	}

	@Override
	public String getHumanReadableName() {
		return humanReadableName;
	}

	@Override
	public void setHumanReadableName(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}

}
