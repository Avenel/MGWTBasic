package de.hska.iwi.mgwt.demo.client.model;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class SettingItemMenueImpl implements SettingItem {

	private InputType inputType;
	private String value;
	private String fontAwesomeIcon;
	private List<SettingItem> settingItems;
	private Place targetPlace;
	
	/**
	 * Public constructor
	 * @param inputType
	 * @param key
	 * @param value
	 * @param fontAwesomeIcon
	 * @param settingItems
	 */
	public SettingItemMenueImpl(SettingMenueName value, String fontAwesomeIcon, List<SettingItem> settingItems) {
		super();
		this.inputType = InputType.MENUELINK;
		this.value = value.toString();
		
		this.targetPlace = new SettingsPlace(this.value);
		
		this.fontAwesomeIcon = fontAwesomeIcon;
		this.settingItems = settingItems;
	}

	@Override
	public InputType getInputType() {
		return this.inputType;
	}

	@Override
	public StorageKey getStorageKey() {
		return StorageKey.MENUELINK;
	}

	@Override
	public String getFontAwesomeIcon() {
		return this.fontAwesomeIcon;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public List<SettingItem> getSettingItems() {
		return settingItems;
	}

	public void setSettingItems(List<SettingItem> settingItems) {
		this.settingItems = settingItems;
	}

	public Place getTargetPlace() {
		return targetPlace;
	}

	public void setTargetPlace(Place targetPlace) {
		this.targetPlace = targetPlace;
	}
	
	public ClickHandler getHandler(final ClientFactory clientFactory) {
		ClickHandler handler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				clientFactory.getPlaceController().goTo(new SettingsPlace(value));
			}
		};
		
		return handler;
	}
	
}
