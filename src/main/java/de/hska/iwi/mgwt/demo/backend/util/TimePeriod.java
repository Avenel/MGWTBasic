package de.hska.iwi.mgwt.demo.backend.util;


public class TimePeriod {
	
	private final String startTime;
	
	private final String endTime;

	public TimePeriod(String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public TimePeriod(String intranetTime) {
		String[] intervall = {"00:00", "00:00"};
		
		if (intranetTime != null && !(intranetTime.trim().isEmpty())) {
			intervall = intranetTime.split("-");
		}
		this.startTime = intervall[0].trim();
		//DUMMER WORKAROUND NEEDS TO BE FIXED
		if (intranetTime.contains("und") || intranetTime.contains("nach") || intranetTime.contains("Fortbildung")) {
			this.endTime = "00:00";
		} else {
			this.endTime = intervall[1].trim();
		}
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
