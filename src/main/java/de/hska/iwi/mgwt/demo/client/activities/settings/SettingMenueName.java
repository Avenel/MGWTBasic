package de.hska.iwi.mgwt.demo.client.activities.settings;

import de.hska.iwi.mgwt.demo.client.model.HumanReadableEnum;

public enum SettingMenueName implements HumanReadableEnum {
	HOME("App-Einstellungen"), IZACCOUNT("IZ Benutzeraccount"), MENSA("Mensa"), NEWS("News");
	
	String humanReadableName;
	
	private SettingMenueName(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}

	@Override
	public String getHumanReadableName() {
		return humanReadableName;
	}

	@Override
	public void setHumanReadableName(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}
	
	public static SettingMenueName getKey(String name) {
		if (name.compareTo("HOME") == 0) return HOME;
		if (name.compareTo("IZACCOUNT") == 0) return IZACCOUNT;
		if (name.compareTo("MENSA") == 0) return MENSA;
		if (name.compareTo("NEWS") == 0) return NEWS;
		
		return HOME;
	}
}


