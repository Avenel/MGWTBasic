package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableBlockCourse;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableEntry;

public class TimetableEntry {
	
	private List<TimetableBlockCourse> entries;
	
	
	public TimetableEntry(ITimetableEntry iEntry) {
		entries = new ArrayList<TimetableBlockCourse>();
		for (ITimetableBlockCourse course : iEntry.getEntries()) {
			entries.add(new TimetableBlockCourse(course));
		}
	}

	/**
	 * @return the entries
	 */
	public List<TimetableBlockCourse> getEntries() {
		return entries;
	}


	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<TimetableBlockCourse> entries) {
		this.entries = entries;
	}
	
}
