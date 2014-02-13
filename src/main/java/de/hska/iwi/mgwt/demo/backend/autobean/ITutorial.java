package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;

public interface ITutorial {
	
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
	 * @return the tutorName
	 */
	public String getTutorName();

	/**
	 * @return the day
	 */
	public Weekday getDay();

	/**
	 * @return the time
	 */
	public String getTime();

	/**
	 * @return the room
	 */
	public int getRoom();

	/**
	 * @return the building
	 */
	public String getBuilding();

	/**
	 * @return the startDate
	 */
	public String getStartDate();

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
	 * @param tutorName the tutorName to set
	 */
	public void setTutorName(String tutorName);

	/**
	 * @param day the day to set
	 */
	public void setDay(Weekday day);

	/**
	 * @param time the time to set
	 */
	public void setTime(String time);

	/**
	 * @param room the room to set
	 */
	public void setRoom(int room);

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building);

	/**
	 * Sets the startDate of this Turtoial.
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate);

}
