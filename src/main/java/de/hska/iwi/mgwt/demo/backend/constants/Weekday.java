package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum Weekday implements IURLParameterEnum {
	@PropertyName("-1")
	NONE(-1, "NONE"),
	@PropertyName("0")
	MONDAY(0, "Montag"),
	@PropertyName("1")
	TUESDAY(1, "Dienstag"),
	@PropertyName("2")
	WEDNESDAY(2, "Mittwoch"),
	@PropertyName("3")
	THURSDAY(3, "Donnerstag"),
	@PropertyName("4")
	FRIDAY(4, "Freitag"),
	@PropertyName("5")
	SATURDAY(5, "Samstag"),
	@PropertyName("6")
	SUNDAY(6, "Sonntag");
	
	private final int numberOfWeekday;
	
	private final String key;
	
	private Weekday(int numberOfWeekday, String key) {
		this.numberOfWeekday = numberOfWeekday;
		this.key = key;
	}
	
//	@JsonCreator
//	public static Weekday create(int value) {
//		for (Weekday day : Weekday.values()) {
//			if (day.getNumberOfWeekday() == value) {
//				return day;
//			}
//		}
//		return NONE;
//	}

	/**
	 * @return the numberOfWeekday
	 */
	private int getNumberOfWeekday() {
		return numberOfWeekday;
	}

	/**
	 * @return the key
	 */
	public String getUrlKey() {
		return key;
	}

	
}
