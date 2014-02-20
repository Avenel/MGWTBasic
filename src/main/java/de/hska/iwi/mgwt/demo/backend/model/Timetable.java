package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITimetable;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableBlockCourse;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableEntry;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
/**
 * Model class for a Timetable.
 * @author Nico
 *
 */
public class Timetable {

	private Course courseOfStudies;
	
	private List<TimetableBlockCourse> blockCourses;
	private List<TimetableEntry> timetables;
		
	private int semester;
	
	private String semesterName;
	
	/**
	 * C'tor which created a deep copy of the given interface type.
	 * @param iTimetable the given interface implementation.
	 */
	public Timetable(ITimetable iTimetable) {
		this.courseOfStudies = iTimetable.getCourseOfStudies();
		
		this.blockCourses = new ArrayList<TimetableBlockCourse>();
		for (ITimetableBlockCourse course : iTimetable.getBlockCourses()) {
			this.blockCourses.add(new TimetableBlockCourse(course));
		}
		
		this.timetables = new ArrayList<TimetableEntry>();
		for (ITimetableEntry iEntry : iTimetable.getTimetables()) {
			this.timetables.add(new TimetableEntry(iEntry));
		}
		
		this.semester = iTimetable.getSemester();
		
		this.semesterName = iTimetable.getSemesterName();
	}

	/**
	 * @return the courseOfStudies
	 */
	public Course getCourseOfStudies() {
		return courseOfStudies;
	}

	/**
	 * @return the blockCourses
	 */
	public List<TimetableBlockCourse> getBlockCourses() {
		return blockCourses;
	}

	/**
	 * @return the timetables
	 */
	public List<TimetableEntry> getTimetables() {
		return timetables;
	}

	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @return the semesterName
	 */
	public String getSemesterName() {
		return semesterName;
	}

	/**
	 * @param courseOfStudies the courseOfStudies to set
	 */
	public void setCourseOfStudies(Course courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}

	/**
	 * @param blockCourses the blockCourses to set
	 */
	public void setBlockCourses(List<TimetableBlockCourse> blockCourses) {
		this.blockCourses = blockCourses;
	}

	/**
	 * @param timetables the timetables to set
	 */
	public void setTimetables(List<TimetableEntry> timetables) {
		this.timetables = timetables;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	/**
	 * @param semesterName the semesterName to set
	 */
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
}
