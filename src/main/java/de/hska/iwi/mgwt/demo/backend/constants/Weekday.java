package de.hska.iwi.mgwt.demo.backend.constants;

/**
 * Enum value for the different Weekdays.
 * @author Nico
 *
 */
public enum Weekday {
	NONE(-1, "NONE"),
	MONDAY(0, "Montag"),
	TUESDAY(1, "Dienstag"),
	WEDNESDAY(2, "Mittwoch"),
	THURSDAY(3, "Donnerstag"),
	FRIDAY(4, "Freitag"),
	SATURDAY(5, "Samstag"),
	SUNDAY(6, "Sonntag");
	
	private final int numberOfWeekday;
	
	private final String weekDayText;
	
	private Weekday(int numberOfWeekday, String key) {
		this.numberOfWeekday = numberOfWeekday;
		this.weekDayText = key;
	}
	
	/**
	 * Factorymethod which creates an Enum for of a given integer value.
	 * @param key the integer value which represents the enum
	 * @return The corresponding enum.
	 */
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
