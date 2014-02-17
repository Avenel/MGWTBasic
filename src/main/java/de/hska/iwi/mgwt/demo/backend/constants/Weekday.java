package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum Weekday {
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
	
	private final String weekDayText;
	
	private Weekday(int numberOfWeekday, String key) {
		this.numberOfWeekday = numberOfWeekday;
		this.weekDayText = key;
	}
	
	public static Weekday getEnumForKey(int key) {
		for (Weekday day : Weekday.values()) {
			if (day.getNumberOfWeekday() == key) {
				return day;
			}
		}
		return Weekday.NONE;
	}
	
	/**
	 * @return the numberOfWeekday
	 */
	public int getNumberOfWeekday() {
		return numberOfWeekday;
	}

	/**
	 * @return the weekDayText for e.g. "Montag"
	 */
	public String getWeekDayText() {
		return weekDayText;
	}

	
}
