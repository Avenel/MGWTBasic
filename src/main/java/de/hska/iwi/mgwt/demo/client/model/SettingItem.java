package de.hska.iwi.mgwt.demo.client.model;

import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public interface SettingItem {
	
	public InputType getInputType();
	public StorageKey getStorageKey();
	public String getFontAwesomeIcon();
	public void setValue(String value);
	public String getValue();
	public double getMinValue();
	public double getMaxValue();
	
}
