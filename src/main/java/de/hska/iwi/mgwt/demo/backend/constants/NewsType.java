package de.hska.iwi.mgwt.demo.backend.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum NewsType implements IURLParameterEnum {
	ANNOUNCEMENT("announcement"),
	announcement("announcement"),
	REARRANGEMENT("rearrangement"),
	rearrangement("rearrangement"),
	CANCELLATION("cancellation"),
	cancellation("cancellation"),
	ROOM_CHANGE("room_change"),
	room_change("room_change");
	
	private final String key;
	
	private NewsType(String key) {
		this.key = key;
	}
	
	@JsonCreator
	public static NewsType create(String value) {
		for (NewsType newsType : NewsType.values()) {
			if (newsType.getUrlKey().equals(value)) {
				return newsType;
			}
		}
		return ANNOUNCEMENT;
	}
		
	/**
	 * @return the key
	 */
	public String getUrlKey() {
		return key;
	}
	
	
}
