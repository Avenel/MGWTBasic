package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.CourseInterval;

public interface ITimetableBlockCourse {

	/**
	 * @return the cancellation
	 */
	public String getCancellation();

	/**
	 * @return the comment
	 */
	public String getComment();

	/**
	 * @return the duration
	 */
	public String getDuration();

	/**
	 * @return the internalName
	 */
	public String getInternalName();

	/**
	 * @return the lectureName
	 */
	public String getLectureName();

	/**
	 * @return the groups
	 */
	public List<String> getGroups();

	/**
	 * @return the lecturerNames
	 */
	public List<String> getLecturerNames();

	/**
	 * @return the startTime
	 */
	public int getStartTime();

	/**
	 * @return the endTime
	 */
	public int getEndTime();

	/**
	 * @return the interval
	 */
	public CourseInterval getInterval();

	/**
	 * @return the locations
	 */
	public List<ILocation> getLocations();

	/**
	 * @param cancellation the cancellation to set
	 */
	public void setCancellation(String cancellation);

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment);

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration);

	/**
	 * @param internalName the internalName to set
	 */
	public void setInternalName(String internalName);

	/**
	 * @param lectureName the lectureName to set
	 */
	public void setLectureName(String lectureName);

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<String> groups);

	/**
	 * @param lecturerNames the lecturerNames to set
	 */
	public void setLecturerNames(List<String> lecturerNames);

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(int startTime);

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(int endTime);

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(CourseInterval interval);

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(List<ILocation> locations);

}
