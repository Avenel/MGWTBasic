package de.hska.iwi.mgwt.demo.client.storage;

/**
 * This enum holds every StorageKey which are used in this app.
 * 
 * @author Martin
 * 
 */
public enum StorageKey {

	NewsSettingsFilterIWI(""), NewsSettingsFilterIB(""), NewsSettingsFilterIM(""), NewsSettingsFilterMKI(""), 
	ProcessesSeminarsList(""), ProcessesSeminarProfessor(""), ProcessesSeminarTerm(""), ProcessesSeminarTopic(""), ProcessesSeminarStatus(""),
	HomeScreenTiles(""), IZAccountname("IZ Benutzername"), IZAccountPassword("IZ Passwort"), IZAccount("IZ Account"),
	IsSendingPushMessages("Pushbenachrichtigungen");
	
	private String humanReadableName;
	
	private StorageKey(String name) {
		this.humanReadableName = name;
	}

	public String getHumanReadableName() {
		return humanReadableName;
	}

	public void setHumanReadableName(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}

}
