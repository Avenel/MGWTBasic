package de.hska.iwi.mgwt.demo.backend.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;
import de.hska.iwi.mgwt.demo.backend.util.TimePeriod;

public class CourseTutorial {
	
	private int id;
	
	private List<Course> courseOfStudies;
	
	private String lectureName;
	
	private String tutorName;
	
	private Weekday day;
	
	private TimePeriod time;
	
	private int room;
	
	private String building;
	
	//yyyy.MM.dd
	private Date startDate;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the courseOfStudies
	 */
	public List<Course> getCourseOfStudies() {
		return courseOfStudies;
	}

	/**
	 * @return the lectureName
	 */
	public String getLectureName() {
		return lectureName;
	}

	/**
	 * @return the tutorName
	 */
	public String getTutorName() {
		return tutorName;
	}

	/**
	 * @return the day
	 */
	public Weekday getDay() {
		return day;
	}

	/**
	 * @return the time
	 */
	public TimePeriod getTime() {
		return time;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param courseOfStudies the courseOfStudies to set
	 */
	public void setCourseOfStudies(List<Course> courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}

	/**
	 * @param lectureName the lectureName to set
	 */
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	/**
	 * @param tutorName the tutorName to set
	 */
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(Weekday day) {
		this.day = day;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(TimePeriod time) {
		this.time = time;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * Sets the startDate of this Turtoial and formats the Date to yyyy-MM-dd if possible
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.startDate = dateFormat.parse(dateFormat.format(startDate));
		} catch (ParseException e) {
			this.startDate = startDate;
		}
	}
	
	

}
