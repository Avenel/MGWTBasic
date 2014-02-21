package de.hska.iwi.mgwt.demo.client.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.storage.client.Storage;
import com.googlecode.gwt.crypto.bouncycastle.DataLengthException;
import com.googlecode.gwt.crypto.bouncycastle.InvalidCipherTextException;
import com.googlecode.gwt.crypto.client.TripleDesCipher;

import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;
import de.hska.iwi.mgwt.demo.client.model.InputType;
import de.hska.iwi.mgwt.demo.client.model.MensaPriceCategory;
import de.hska.iwi.mgwt.demo.client.model.SettingItem;
import de.hska.iwi.mgwt.demo.client.model.SettingItemImpl;
import de.hska.iwi.mgwt.demo.client.model.SettingItemMenueImpl;

public class SettingStorage {

	private static final byte[] GWT_DES_KEY = new byte[]{
        (byte)4,(byte)8,(byte)3,(byte)80,(byte)12,(byte)-9,(byte)-5,(byte)101, 
        (byte)15,(byte)-8,(byte)3,(byte)0,(byte)90,(byte)-9,(byte)55,(byte)-41, 
        (byte)-9,(byte)90,(byte)3,(byte)100,(byte)-40,(byte)79,(byte)5,(byte)102};
	
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
		SettingItemImpl mensaPrice = new SettingItemImpl(InputType.ACCORDION, StorageKey.MENSAPRICECATEGORY, "Student", "fa-calendar", false, new String[]{
						MensaPriceCategory.STUDENT.getHumanReadableName(), MensaPriceCategory.EMPLOYEE.getHumanReadableName(), MensaPriceCategory.PUPIL.getHumanReadableName(),
						MensaPriceCategory.GUEST.getHumanReadableName()});
		settingItemsMensa.add(mensaDays);
		settingItemsMensa.add(mensaPrice);
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
			String returnValue = stockStore.getItem(key.toString());
			
			if (returnValue == null) throw new Exception();
			
			// decrypt if necessary
			if (isSecure) {
				TripleDesCipher cipher = new TripleDesCipher();
				cipher.setKey(GWT_DES_KEY);
				try {
				  returnValue = cipher.decrypt(returnValue);
				} catch (DataLengthException e) {
				  e.printStackTrace();
				} catch (IllegalStateException e) {
				  e.printStackTrace();
				} catch (InvalidCipherTextException e) {
				  e.printStackTrace();
				}
			}
			
			return returnValue;
		} else {
			// TODO find better exception
			throw new Exception();
		}
	}
	
	public static void storeValue(StorageKey key, String value, boolean isSecure) {
		// store value in local storage
		Storage stockStore = Storage.getLocalStorageIfSupported();
		
		if (stockStore != null) {
			// encrypt if necessary
			if (isSecure) {
				TripleDesCipher cipher = new TripleDesCipher();
				cipher.setKey(GWT_DES_KEY);
				try {
				  value = cipher.encrypt(String.valueOf(value));
				} catch (DataLengthException e1) {
				  e1.printStackTrace();
				} catch (IllegalStateException e1) {
				  e1.printStackTrace();
				} catch (InvalidCipherTextException e1) {
				  e1.printStackTrace();
				}
			} 
			
			stockStore.setItem(key.toString(), value);
		}
	}
	
}
