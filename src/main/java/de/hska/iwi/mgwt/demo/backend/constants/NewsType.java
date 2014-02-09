package de.hska.iwi.mgwt.demo.backend.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum NewsType implements IURLParameterEnum {
	ANNOUNCEMENT("announcement"),
	REARRANGEMENT("rearrangement"),
	CANCELLATION("cancellation"),
	ROOM_CHANGE("room_change");
	
	private final String key;
	
	private NewsType(String key) {
		this.key = key;
	}
	
	@JsonCreator
	public static NewsType create(String value) {
		for (NewsType newsType : NewsType.values()) {
			if (newsType.getKey().equals(value)) {
				return newsType;
			}
		}
		return ANNOUNCEMENT;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	public String getFontAwesome() {
		if (this.getKey().equals("announcement")) {
			return "fa-exclamation-triangle";
		}
		if (this.getKey().equals("rearrangement")) {
			return "fa-calendar";
		}
		if (this.getKey().equals("cancellation")) {
			return "fa-ban";
		}
		if (this.getKey().equals("room_change")) {
			return "fa-arrows-h";
		}
		
		return "fa-envelope";
	}
	
	
}
