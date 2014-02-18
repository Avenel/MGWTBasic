package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ILocation;
import de.hska.iwi.mgwt.demo.backend.autobean.ITimetableBlockCourse;
import de.hska.iwi.mgwt.demo.backend.constants.CourseInterval;

public class TimetableBlockCourse {

	private String cancellation;
	private String comment;
	private String duration;
	private String internalName;
	private String lectureName;
	
	private List<String> groups;
	private List<String> lecturerNames;
	
	private int startTime;
	private int endTime;
	
	private CourseInterval interval;
	
	private List<Location> locations;

	/**
	 * Constructor which makes a copy of a corresponding GWT AutoBean Interface type to this model
	 * @param course the AutoBean Interfacetype
	 */
	public TimetableBlockCourse(ITimetableBlockCourse course) {
		this.cancellation = course.getCancellation();
		this.comment = course.getComment();
		this.duration = course.getDuration();
		this.internalName = course.getInternalName();
		this.lectureName = course.getLectureName();
		
		this.groups = course.getGroups();
		this.lecturerNames = course.getLecturerNames();
		
		this.startTime = course.getStartTime();
		this.endTime = course.getEndTime();
		
		this.interval = course.getInterval();
		
		this.locations = new ArrayList<Location>();
		for (ILocation iLoc : course.getLocations()) {
			locations.add(new Location(iLoc));
		}
	}

	/**
	 * @return hint of cancellation or empty String if nothing exists
	 */
	public String getCancellation() {
		return cancellation;
	}

	/**
	 * Getter for comment
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Getter for the duration
	 * @return description of the duration of this course
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * Getter for internalName
	 * @return the internal Name of this course
	 */
	public String getInternalName() {
		return internalName;
	}

	/**
	 * Getter for lecturer Name
	 * @return name of the lecturer
	 */
	public String getLectureName() {
		return lectureName;
	}

	/**
	 * Getter for the groups
	 * @return the list of groups or an empty list if none is available
	 */
	public List<String> getGroups() {
		return groups == null ? Collections.<String>emptyList() : groups;
	}

	/**
	 * Getter for the lecturerNames
	 * @return the list of lectureres or an empty list if none is available
	 */
	public List<String> getLecturerNames() {
		return lecturerNames == null ? Collections.<String>emptyList() : lecturerNames;
	}

	/**
	 * Getter for the starttime. This time is represented by the hours from midnight.
	 * @return starttime in hours from midnight
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Getter for the endtime. This time is represented by the hours from midnight.
	 * @return endtime in hours from midnight
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * Getter for the interval of the course
	 * @return {@see CourseInterval}
	 */
	public CourseInterval getInterval() {
		return interval;
	}

	/**
	 * Getter for the Locations
	 * @return the list of locations
	 */
	public List<Location> getLocations() {
		return locations;
	}

	/**
	 * setter for the cancellation
	 * @param cancellation value to set
	 */
	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

	/**
	 * Setter for the comment
	 * @param comment value to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Setter for the duration
	 * @param duration value to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * Setter for the internal name
	 * @param internalName value to set
	 */
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	/**
	 * Setter for the lecturer name
	 * @param lectureName value to set
	 */
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	/**
	 * Setter for the groups
	 * @param groups value to set
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	/**
	 * Setter for the lecturerNames
	 * @param lecturerNames value to set
	 */
	public void setLecturerNames(List<String> lecturerNames) {
		this.lecturerNames = lecturerNames;
	}

	/**
	 * Setter for the starttime
	 * @param startTime value to set
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * Setter for the endTime
	 * @param endTime value to set
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	/**
	 * Setter for the interval
	 * @param interval a {@link CourseInteval} to set
	 */
	public void setInterval(CourseInterval interval) {
		this.interval = interval;
	}

	/**
	 * Setter for the Location
	 * @param locations value to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
}
