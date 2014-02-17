package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum NewsType implements IURLParameterEnum {
	@PropertyName("announcement")
	ANNOUNCEMENT("announcement"),
	@PropertyName("rearrangement")
	REARRANGEMENT("rearrangement"),
	@PropertyName("cancellation")
	CANCELLATION("cancellation"),
	@PropertyName("room_change")
	ROOM_CHANGE("room_change");
	
	private final String key;
	
	private NewsType(String key) {
		this.key = key;
	}
			
	/**
	 * @return the key
	 */
	public String getUrlKey() {
		return key;
	}
	
	public String getFontAwesomeIcon() {
		if (this.getUrlKey().equals("announcement")) {
			return "fa-bullhorn";
		}
		if (this.getUrlKey().equals("rearrangement")) {
			return "fa-calendar";
		}
		if (this.getUrlKey().equals("cancellation")) {
			return "fa-ban";
		}
		if (this.getUrlKey().equals("room_change")) {
			return "fa-arrows-h";
		}
		
		return "fa-envelope";
	}
	
}