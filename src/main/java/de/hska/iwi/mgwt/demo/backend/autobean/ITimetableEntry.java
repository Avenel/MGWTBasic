package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface ITimetableEntry {

	/**
	 * @return the entries
	 */
	public List<ITimetableBlockCourse> getEntries();

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<ITimetableBlockCourse> entries);
}
