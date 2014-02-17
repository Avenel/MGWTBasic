package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHour;
import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHours;

public class ConsultationHours {
	
	List<ConsultationHour> hours;

	public ConsultationHours(IConsultationHours hours) {
		for (IConsultationHour hour : hours.getConsultationHours()) {
			this.hours.add(new ConsultationHour(hour));
		}
	}
	
	/**
	 * @return the hours
	 */
	public List<ConsultationHour> getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(List<ConsultationHour> hours) {
		this.hours = hours;
	}

}
