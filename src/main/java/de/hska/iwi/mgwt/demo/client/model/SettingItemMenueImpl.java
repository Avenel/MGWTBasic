package de.hska.iwi.mgwt.demo.client.model;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Represents a link to a settings menu. It is used like a normal 
 * setting item, so the setting activity can handle it easily. It also
 * holds the setting items, which belong to the desired settings menu.
 * 
 * @author Martin
 *
 */
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
	 * @param value Setting menue name, equals to target setting place.
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

	/**
	 * Getter for list of setting items.
	 * @return List<SettingItem> setting item list
	 */
	public List<SettingItem> getSettingItems() {
		return settingItems;
	}
	
	/**
	 * Setter for setting item list. 
	 * @param settingItems
	 */
	public void setSettingItems(List<SettingItem> settingItems) {
		this.settingItems = settingItems;
	}

	/**
	 * Getter for the targeted setting place.
	 * @return
	 */
	public Place getTargetPlace() {
		return targetPlace;
	}

	/**
	 * Setter for targeted setting place.
	 * @param targetPlace
	 */
	public void setTargetPlace(Place targetPlace) {
		this.targetPlace = targetPlace;
	}
	
	/**
	 * Getter for the ClickHandler of this menue link.
	 * @param clientFactory
	 * @return ClickHandler handler
	 */
	public ClickHandler getHandler(final ClientFactory clientFactory) {
		ClickHandler handler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				clientFactory.getPlaceController().goTo(new SettingsPlace(value));
			}
		};
		
		return handler;
	}

	@Override
	public String[] getValues() {
		return null;
	}
	
}
