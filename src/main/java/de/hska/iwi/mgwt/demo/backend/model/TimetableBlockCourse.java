package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
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

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getCancellation()
	 */
	public String getCancellation() {
		return cancellation;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getComment()
	 */
	public String getComment() {
		return comment;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getDuration()
	 */
	public String getDuration() {
		return duration;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getInternalName()
	 */
	public String getInternalName() {
		return internalName;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getLectureName()
	 */
	public String getLectureName() {
		return lectureName;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getGroups()
	 */
	public List<String> getGroups() {
		return groups;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getLecturerNames()
	 */
	public List<String> getLecturerNames() {
		return lecturerNames;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getStartTime()
	 */
	public int getStartTime() {
		return startTime;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getEndTime()
	 */
	public int getEndTime() {
		return endTime;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getInterval()
	 */
	public CourseInterval getInterval() {
		return interval;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#getLocations()
	 */
	public List<Location> getLocations() {
		return locations;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setCancellation(java.lang.String)
	 */
	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setComment(java.lang.String)
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setDuration(java.lang.String)
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setInternalName(java.lang.String)
	 */
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setLectureName(java.lang.String)
	 */
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setGroups(java.util.List)
	 */
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setLecturerNames(java.util.List)
	 */
	public void setLecturerNames(List<String> lecturerNames) {
		this.lecturerNames = lecturerNames;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setStartTime(int)
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setEndTime(int)
	 */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setInterval(de.hska.iwi.mgwt.demo.backend.constants.CourseInterval)
	 */
	public void setInterval(CourseInterval interval) {
		this.interval = interval;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.TEST#setLocations(java.util.List)
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
}
