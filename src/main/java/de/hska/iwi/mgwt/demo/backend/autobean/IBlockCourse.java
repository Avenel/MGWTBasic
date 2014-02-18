package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;

public interface IBlockCourse {

	/**
	 * @return the id
	 */
	public int getId();

	/**
	 * @return the courseOfStudies
	 */
	public List<Course> getCourseOfStudies();

	/**
	 * @return the lectureName
	 */
	public String getLectureName();

	/**
	 * @return the lecturerNames
	 */
	public String getLecturerNames();

	/**
	 * @return the dates
	 */
	public String getDates();

	/**
	 * @return the times
	 */
	public String getTimes();

	/**
	 * @return the buildingAndRoom
	 */
	public String getBuildingAndRoom();

	/**
	 * @param id the id to set
	 */
	public void setId(int id);

	/**
	 * @param courseOfStudies the courseOfStudies to set
	 */
	public void setCourseOfStudies(List<Course> courseOfStudies);

	/**
	 * @param lectureName the lectureName to set
	 */
	public void setLectureName(String lectureName);

	/**
	 * @param lecturerNames the lecturerNames to set
	 */
	public void setLecturerNames(String lecturerNames);

	/**
	 * @param dates the dates to set
	 */
	public void setDates(String dates);

	/**
	 * @param times the times to set
	 */
	public void setTimes(String times);

	/**
	 * @param buildingAndRoom the buildingAndRoom to set
	 */
	public void setBuildingAndRoom(String buildingAndRoom);
}
