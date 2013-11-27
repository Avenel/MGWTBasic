package de.hska.iwi.mgwt.demo.backend.constants;

public enum Weekday {
	
	MONDAY(0, "Montag"),
	TUESDAY(1, "Dienstag"),
	WEDNESDAY(2, "Mittwoch"),
	THURSDAY(3, "Donnerstag"),
	FRIDAY(4, "Freitag"),
	SATURDAY(5, "Samstag"),
	SUNDAY(6, "Sonntag");
	
	private final int numberOfWeekday;
	
	private final String strWeekday;
	
	private Weekday(int numberOfWeekday, String strWeekday) {
		this.numberOfWeekday = numberOfWeekday;
		this.strWeekday = strWeekday;
	}
}
