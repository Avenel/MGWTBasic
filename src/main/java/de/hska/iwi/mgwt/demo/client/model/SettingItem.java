package de.hska.iwi.mgwt.demo.client.model;

import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Interface for a setting item. A setting item has its key and value(s). 
 * An icon (font awesome icon string).
 * @author Martin
 *
 */
public interface SettingItem {
	
	/**
	 * Getter for InputType.
	 * @return InputType input type
	 */
	public InputType getInputType();
	
	/**
	 * Getter for storage key.
	 * @return StorageKey key
	 */
	public StorageKey getStorageKey();
	
	/**
	 * Getter for font awesome icon string.
	 * @return String font awesome icon string
	 */
	public String getFontAwesomeIcon();
	
	/**
	 * Setter for value (String)
	 * @param String value
	 */
	public void setValue(String value);
	
	/**
	 * Getter for value
	 * @return String value
	 */
	public String getValue();
	
	/**
	 * Getter for an array of values, if there are more than one value, stored in the setting storage.
	 * @return String[] values
	 */
	public String[] getValues();
	
}
