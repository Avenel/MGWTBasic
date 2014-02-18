package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;

public interface ITimetable {

	/**
	 * @return the courseOfStudies
	 */
	public Course getCourseOfStudies();

	/**
	 * @return the blockcourses
	 */
	public List<ITimetableBlockCourse> getBlockCourses();

	/**
	 * @return the timetables
	 */
	public List<ITimetableEntry> getTimetables();

	/**
	 * @return the semester
	 */
	public int getSemester();

	/**
	 * @return the semesterName
	 */
	public String getSemesterName();

	/**
	 * @param courseOfStudies the courseOfStudies to set
	 */
	public void setCourseOfStudies(Course courseOfStudies);

	/**
	 * @param blockcourses the blockcourses to set
	 */
	public void setBlockCourses(List<ITimetableBlockCourse> blockCourses);

	/**
	 * @param timetables the timetables to set
	 */
	public void setTimetables(List<ITimetableEntry> timetables);

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester);

	/**
	 * @param semesterName the semesterName to set
	 */
	public void setSemesterName(String semesterName);
	
}
