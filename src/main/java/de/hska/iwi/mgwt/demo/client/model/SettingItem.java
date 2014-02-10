package de.hska.iwi.mgwt.demo.client.model;

import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Represents a possible setting
 * @author avenel
 *
 */
public class SettingItem {
	private StorageKey key;
	private String value;
	private boolean isSecure;
	private String fontAwesomeIcom;
	private InputType inputType;
	
	/**
	 * Public constructor
	 * @param key
	 * @param value
	 * @param isSecure
	 */
	public SettingItem(StorageKey key, String value, boolean isSecure,
			String fontAwesomeIcom, InputType inputType) {
		this.key = key;
		this.value = value;
		this.isSecure = isSecure;
		this.fontAwesomeIcom = fontAwesomeIcom;
		this.setInputType(inputType);
	}
	
	public StorageKey getKey() {
		return key;
	}
	
	public void setKey(StorageKey key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isSecure() {
		return isSecure;
	}
	
	public void setSecure(boolean isSecure) {
		this.isSecure = isSecure;
	}
	
	public String getFontAwesomeIcom() {
		return fontAwesomeIcom;
	}
	
	public void setFontAwesomeIcom(String fontAwesomeIcom) {
		this.fontAwesomeIcom = fontAwesomeIcom;
	}


	public InputType getInputType() {
		return inputType;
	}


	public void setInputType(InputType inputType) {
		this.inputType = inputType;
	}
}
