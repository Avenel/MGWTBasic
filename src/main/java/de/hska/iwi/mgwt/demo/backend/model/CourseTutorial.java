package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITutorial;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;

/**
 * Holds the provided information about an CourseTutorial
 * @author Nico
 *
 */
public class CourseTutorial implements ITutorial {
	
	private int id;
	private int room;
	
	private List<Course> courseOfStudies;
	
	private String lectureName;
	private String tutorName;
	private String time;
	private String building;
	private String startDate;
	
	private Weekday day;
	
	/**
	 * C'tor which created a deep copy of the given interface type.
	 * @param iTutorial the given interface implementation.
	 */
	public CourseTutorial(ITutorial iTutorial) {
		this.id = iTutorial.getId();
		this.courseOfStudies = iTutorial.getCourseOfStudies();
		this.lectureName = iTutorial.getLectureName();
		this.tutorName = iTutorial.getTutorName();
		this.day = iTutorial.getDay();
		this.time = iTutorial.getTime();
		this.room = iTutorial.getRoom();
		this.building = iTutorial.getBuilding();
		this.startDate = iTutorial.getStartDate();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public int getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Course> getCourseOfStudies() {
		return courseOfStudies;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLectureName() {
		return lectureName;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTutorName() {
		return tutorName;
	}

	/**
	 * {@inheritDoc}
	 */
	public Weekday getDay() {
		return day;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTime() {
		return time;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setCourseOfStudies(List<Course> courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDay(Weekday day) {
		this.day = day;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	

}
