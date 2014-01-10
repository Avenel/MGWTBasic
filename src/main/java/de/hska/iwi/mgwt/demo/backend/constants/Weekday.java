package de.hska.iwi.mgwt.demo.backend.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Weekday implements IURLParameterEnum {
	NONE(-1, "NONE"),
	MONDAY(0, "Montag"),
	TUESDAY(1, "Dienstag"),
	WEDNESDAY(2, "Mittwoch"),
	THURSDAY(3, "Donnerstag"),
	FRIDAY(4, "Freitag"),
	SATURDAY(5, "Samstag"),
	SUNDAY(6, "Sonntag");
	
	private final int numberOfWeekday;
	
	private final String key;
	
	private Weekday(int numberOfWeekday, String key) {
		this.numberOfWeekday = numberOfWeekday;
		this.key = key;
	}
	
	@JsonCreator
	public static Weekday create(int value) {
		for (Weekday day : Weekday.values()) {
			if (day.getNumberOfWeekday() == value) {
				return day;
			}
		}
		return NONE;
	}

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
