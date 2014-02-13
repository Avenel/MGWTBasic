package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITutorial;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;

public class CourseTutorial implements ITutorial {
	
	private int id;
	
	private List<Course> courseOfStudies;
	
	private String lectureName;
	
	private String tutorName;
	
	private Weekday day;
	
	private String time;
	
	private int room;
	
	private String building;
	
	//yyyy.MM.dd
	private String startDate;

	
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
	public String getTime() {
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
	public String getStartDate() {
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
	public void setTime(String time) {
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
	public void setStartDate(String startDate) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			this.startDate = dateFormat.parse(dateFormat.format(startDate));
//		} catch (ParseException e) {
			this.startDate = startDate;
//		}
	}
	
	

}
