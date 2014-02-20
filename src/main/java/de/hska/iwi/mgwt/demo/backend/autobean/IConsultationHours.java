package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IConsultationHours {

	/**
	 * @return the consultationHours
	 */
	public List<IConsultationHour> getConsultationHours();
	/**
	 * 
	 * @param hours the ConsultationHours to set
	 */
	public void setConsultationHours(List<IConsultationHour> hours);
}
