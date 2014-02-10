package de.hska.iwi.mgwt.demo.client.storage;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.client.model.InputType;
import de.hska.iwi.mgwt.demo.client.model.SettingItem;

public class SettingStorage {

	private static List<SettingItem> settingItems;
	
	
	public static List<SettingItem> getSettingItems() {
		if (settingItems == null) {
			settingItems = new ArrayList<SettingItem>();
			
			SettingItem izUserMenu = new SettingItem(StorageKey.IZAccount, "", false, "fa-user", InputType.MENUELINK);
			SettingItem izUserAccount = new SettingItem(StorageKey.IZAccountname, "brma0004", false, "fa-user", InputType.TEXT);
			SettingItem izUserPassword = new SettingItem(StorageKey.IZAccountPassword, "123456", true, "fa-key", InputType.PASSWORD);
			SettingItem pushMessagesAllowed = new SettingItem(StorageKey.IsSendingPushMessages, "true", false, "fa-mail-forward", InputType.CHECKBOX);
			
			settingItems.add(izUserMenu);
			settingItems.add(izUserAccount);
			settingItems.add(izUserPassword);
			settingItems.add(pushMessagesAllowed);
		}
		
		return settingItems;
	}
	
	
}
