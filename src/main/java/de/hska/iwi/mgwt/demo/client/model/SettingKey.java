package de.hska.iwi.mgwt.demo.client.model;

public enum SettingKey {
	IZACCOUNTNAME("IZ Benutzername"), IZACCOUNTPASSWORD("IZ Passwort"), IZACCOUNT("IZ Account");
	
	private String humanReadableName;
	
	private SettingKey(String name) {
		this.humanReadableName = name;
	}

	public String getHumanReadableName() {
		return humanReadableName;
	}

	public void setHumanReadableName(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}
	
	
}
