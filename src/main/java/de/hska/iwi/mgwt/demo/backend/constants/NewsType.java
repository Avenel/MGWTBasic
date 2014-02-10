package de.hska.iwi.mgwt.demo.backend.constants;

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
	
	public String getFontAwesomeIcon() {
		if (this.getUrlKey().equals("announcement")) {
			return "fa-exclamation-triangle";
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