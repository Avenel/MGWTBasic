package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

public class SettingStorage {

	private static List<SettingItem> settingItems;
	
	
	public static List<SettingItem> getSettingItems() {
		if (settingItems == null) {
			settingItems = new ArrayList<SettingItem>();
			
			SettingItem izUserMenu = new SettingItem(SettingKey.IZACCOUNT, "", false, "fa-user", InputType.MENUE);
			SettingItem izUserAccount = new SettingItem(SettingKey.IZACCOUNTNAME, "brma0004", false, "fa-user", InputType.TEXT);
			SettingItem izUserPassword = new SettingItem(SettingKey.IZACCOUNTPASSWORD, "123456", true, "fa-key", InputType.PASSWORD);
			
			settingItems.add(izUserMenu);
			settingItems.add(izUserAccount);
			settingItems.add(izUserPassword);
		}
		
		return settingItems;
	}
	
	
}
