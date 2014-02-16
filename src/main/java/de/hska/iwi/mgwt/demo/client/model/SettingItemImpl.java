package de.hska.iwi.mgwt.demo.client.model;

import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;


/**
 * Represents a possible setting
 * @author avenel
 *
 */
public class SettingItemImpl implements SettingItem {
	
	private InputType inputType;
	private StorageKey key;
	private String value;
	private String fontAwesomeIcon;
	private boolean isSecure;
	private double min, max;
	
	
	
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
	 * Public constructor
	 * @param inputType
	 * @param key
	 * @param value
	 * @param fontAwesomeIcon
	 * @param isSecure
	 */
	public SettingItemImpl(InputType inputType, StorageKey key, String value,
			String fontAwesomeIcon, boolean isSecure, double min, double max) {
		super();
		this.inputType = inputType;
		this.key = key;
		this.value = value;
		this.fontAwesomeIcon = fontAwesomeIcon;
		this.isSecure = isSecure;
		this.min = min;
		this.max = max;
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
	public double getMinValue() {
		return this.min;
	}

	@Override
	public double getMaxValue() {
		return this.max;
	}
}
