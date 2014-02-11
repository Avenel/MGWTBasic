package de.hska.iwi.mgwt.demo.client.activities.settings;

import de.hska.iwi.mgwt.demo.client.model.HumanReadableEnum;

public enum SettingMenueName implements HumanReadableEnum {
	HOME("Home"), IZACCOUNT("IZ Benuteraccount");
	
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
		
		return HOME;
	}
}

