package de.hska.iwi.mgwt.demo.client.model;

import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;


/**
 * Represents a possible setting item.
 * Use it for following InputTypes: TEXT, CHECKBOX, PASSWORD, ACCORDION
 * @author avenel
 *
 */
public class SettingItemImpl implements SettingItem {
	
	private InputType inputType;
	private StorageKey key;
	private String value;
	private String fontAwesomeIcon;
	private boolean isSecure;
	private String[] values;
	
	
	
	/**
	 * Public constructor
	 * @param inputType
	 * @param key
	 * @param value
	 * @param fontAwesomeIcon
	 * @param isSecure
	 */
	public SettingItemImpl(InputType inputType, StorageKey key, String value,
			String fontAwesomeIcon, boolean isSecure) {
		super();
		this.inputType = inputType;
		this.key = key;
		this.value = value;
		this.fontAwesomeIcon = fontAwesomeIcon;
		this.isSecure = isSecure;
	}
	
	/**
	 * Public constructor for a setting item with more than one value.
	 * @param inputType
	 * @param key
	 * @param value
	 * @param fontAwesomeIcon
	 * @param isSecure
	 */
	public SettingItemImpl(InputType inputType, StorageKey key, String value,
			String fontAwesomeIcon, boolean isSecure, String[] values) {
		super();
		this.inputType = inputType;
		this.key = key;
		this.value = value;
		this.fontAwesomeIcon = fontAwesomeIcon;
		this.isSecure = isSecure;
		this.values = values;
	}

	@Override
	public InputType getInputType() {
		return this.inputType;
	}

	@Override
	public StorageKey getStorageKey() {
		return this.key;
	}

	@Override
	public String getFontAwesomeIcon() {
		return this.fontAwesomeIcon;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
		SettingStorage.storeValue(this.key, value, this.isSecure);
	}

	@Override
	public String getValue() {
		try {
			this.value = SettingStorage.getValue(this.key, this.isSecure);
		} catch (Exception e) {
			this.value = "[ERR]";
		}
		return this.value;
	}

	@Override
	public String[] getValues() {
		return this.values;
	}
}
