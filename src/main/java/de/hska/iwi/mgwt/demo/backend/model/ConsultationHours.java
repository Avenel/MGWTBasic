package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHour;
import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHours;
/**
 * Model class for ConsultationHours, holds one or more {@link ConsultationHours}-objects.
 * @author Nico
 *
 */
public class ConsultationHours {
	
	List<ConsultationHour> hours;

	/**
	 * C'tor which creates a deep copy of the given Interface implementation.
	 * @param hours the given Implementation 
	 */
	public ConsultationHours(IConsultationHours hours) {
		this.hours = new ArrayList<ConsultationHour>();
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
