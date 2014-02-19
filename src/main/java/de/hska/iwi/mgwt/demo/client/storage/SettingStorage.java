package de.hska.iwi.mgwt.demo.client.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.storage.client.Storage;

import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;
import de.hska.iwi.mgwt.demo.client.model.InputType;
import de.hska.iwi.mgwt.demo.client.model.SettingItem;
import de.hska.iwi.mgwt.demo.client.model.SettingItemImpl;
import de.hska.iwi.mgwt.demo.client.model.SettingItemMenueImpl;

public class SettingStorage {

	private static Map<SettingMenueName, List<SettingItem>> settingItems;
	
	public static void init() {
		settingItems = new HashMap<SettingMenueName, List<SettingItem>>();
		
		// HOME
		List<SettingItem> settingItemsHome = new ArrayList<SettingItem>();
		
		// MenuLink: IZAccount
		List<SettingItem> settingItemsIZAccount = new ArrayList<SettingItem>();
		SettingItemImpl izUserAccount = new SettingItemImpl(InputType.TEXT, StorageKey.IZAccountname, "brma0004", "fa-user", false);
		SettingItemImpl izUserPassword = new SettingItemImpl(InputType.PASSWORD, StorageKey.IZAccountPassword, "123456", "fa-key", true);
		settingItemsIZAccount.add(izUserAccount);
		settingItemsIZAccount.add(izUserPassword);
		SettingItemMenueImpl izUserMenu = new SettingItemMenueImpl(SettingMenueName.IZACCOUNT, "fa-user", settingItemsIZAccount);
		
		// MenuLink: MENSA
		List<SettingItem> settingItemsMensa = new ArrayList<SettingItem>();
		SettingItemImpl mensaDays = new SettingItemImpl(InputType.ACCORDION, StorageKey.MENSADAYCOUNT, "3", "fa-calendar", false, new String[]{"1", "2", "3", "4", "5"});
		settingItemsMensa.add(mensaDays);
		SettingItemMenueImpl mensaSettings = new SettingItemMenueImpl(SettingMenueName.MENSA, "fa-cutlery", settingItemsMensa);
		
		// MenuLink: NEWS
		List<SettingItem> settingItemsNews = new ArrayList<SettingItem>();
		SettingItemImpl filterIB = new SettingItemImpl(InputType.CHECKBOX, StorageKey.NewsSettingsFilterIB, "true", "fa-mail-forward", false);
		SettingItemImpl filterIM = new SettingItemImpl(InputType.CHECKBOX, StorageKey.NewsSettingsFilterIM, "true", "fa-mail-forward", false);
		SettingItemImpl filterMKI = new SettingItemImpl(InputType.CHECKBOX, StorageKey.NewsSettingsFilterMKI, "true", "fa-mail-forward", false);
		
		settingItemsNews.add(filterIB);
		settingItemsNews.add(filterIM);
		settingItemsNews.add(filterMKI);
		
		SettingItemMenueImpl newsSettings = new SettingItemMenueImpl(SettingMenueName.NEWS, "fa-bullhorn", settingItemsMensa);
		
		// General
		SettingItemImpl pushMessagesAllowed = new SettingItemImpl(InputType.CHECKBOX, StorageKey.IsSendingPushMessages, "true", "fa-mail-forward", false);
		
		settingItemsHome.add(izUserMenu);
		settingItemsHome.add(mensaSettings);
		settingItemsHome.add(newsSettings);
		settingItemsHome.add(pushMessagesAllowed);
		
		settingItems.put(SettingMenueName.HOME, settingItemsHome);
		settingItems.put(SettingMenueName.MENSA, settingItemsMensa);
		settingItems.put(SettingMenueName.NEWS, settingItemsNews);
		settingItems.put(SettingMenueName.IZACCOUNT, settingItemsIZAccount);
	}
	
	public static List<SettingItem> getSettingItems(SettingMenueName key) {
		if (settingItems == null) {
			init();
		}
		
		return settingItems.get(key);
	}
	
	public static String getValue(StorageKey key, boolean isSecure) throws Exception {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		
		if (stockStore != null) {
			// TODO decrypt if necessary
			if (isSecure) {
				return stockStore.getItem(key.toString());
			}
			
			return stockStore.getItem(key.toString());
		} else {
			// TODO find better exception
			throw new Exception();
		}
	}
	
	public static void storeValue(StorageKey key, String value, boolean isSecure) {
		// store value in local storage
		Storage stockStore = Storage.getLocalStorageIfSupported();
		
		// TODO encrypt if necessary
		if (stockStore != null) {
			stockStore.setItem(key.toString(), value);
		}
	}
	
}
