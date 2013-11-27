package de.hska.iwi.mgwt.demo.backend.util;

import java.text.SimpleDateFormat;

public class TimePeriod {
	
	private final String startTime;
	
	private final String endTime;

	public TimePeriod(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public TimePeriod(String intranetTime) {
		SimpleDateFormat format = new SimpleDateFormat("HH:MM");
		String[] intervall = {"00:00", "00:00"};
		if (intranetTime != null) {
			intervall = intranetTime.split("-");
		}
		this.startTime = format.format(intervall[0]);
		this.endTime = format.format(intervall[1]);
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	
	/**
	 * Create a period out of the start- and endtime
	 * For example: start: 14:00, end: 15:30 -> 14:00-15:30 
	 * @return start- endtime as a period.
	 */
	public String getTimePeriod() {
		return this.startTime + "-" + this.endTime;
	}

}
