package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITimetable;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableBlockCourse;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableEntry;
import de.hska.iwi.mgwt.demo.backend.constants.Course;

public class Timetable {

	private Course courseOfStudies;
	
	private List<TimetableBlockCourse> blockcourses;
	private List<TimetableEntry> timetables;
		
	private int semester;
	
	private String semesterName;
	
	public Timetable(ITimetable iTimetable) {
		this.courseOfStudies = iTimetable.getCourseOfStudies();
		
		this.blockcourses = new ArrayList<TimetableBlockCourse>();
		for (ITimetableBlockCourse course : iTimetable.getBlockcourses()) {
			this.blockcourses.add(new TimetableBlockCourse(course));
		}
		
		this.timetables = new ArrayList<TimetableEntry>();
		for (ITimetableEntry iEntry : iTimetable.getTimetables()) {
			this.timetables.add(new TimetableEntry(iEntry));
		}
		
		this.semester = iTimetable.getSemester();
		
		this.semesterName = iTimetable.getSemesterName();
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#getCourseOfStudies()
	 */
	public Course getCourseOfStudies() {
		return courseOfStudies;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#getBlockcourses()
	 */
	public List<TimetableBlockCourse> getBlockcourses() {
		return blockcourses;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#getTimetables()
	 */
	public List<TimetableEntry> getTimetables() {
		return timetables;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#getSemester()
	 */
	public int getSemester() {
		return semester;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#getSemesterName()
	 */
	public String getSemesterName() {
		return semesterName;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#setCourseOfStudies(de.hska.iwi.mgwt.demo.backend.constants.Course)
	 */
	public void setCourseOfStudies(Course courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#setBlockcourses(java.util.List)
	 */
	public void setBlockcourses(List<TimetableBlockCourse> blockcourses) {
		this.blockcourses = blockcourses;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#setTimetables(java.util.List)
	 */
	public void setTimetables(List<TimetableEntry> timetables) {
		this.timetables = timetables;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#setSemester(int)
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ItestTimeTable#setSemesterName(java.lang.String)
	 */
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
}
