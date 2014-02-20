package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableBlockCourse;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableEntry;
/**
 * Model class for a entry in a Timetable. This holds one or more {@link TimetableBlockCourse} objects.
 * @author Nico
 *
 */
public class TimetableEntry {
	
	private List<TimetableBlockCourse> entries;
	
	/**
	 * C'tor which creates a deep copy of the given Interface type.
	 * @param iEntry the given interface implementation type.
	 */
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
