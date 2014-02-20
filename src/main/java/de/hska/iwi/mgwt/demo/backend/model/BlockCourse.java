package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IBlockCourse;
import de.hska.iwi.mgwt.demo.backend.constants.Course;

/**
 * Model class for a Blockcourse, holds the provided data.
 * @author Nico
 *
 */
public class BlockCourse implements IBlockCourse {
	
	private int id;
	
	private List<Course> courseOfStudies;
	
	private String lectureName;
	//perhaps a list of Strings, if all lectureres are lists, currently they are just a simple long String seperated by a comma
	private String lecturerNames;
	private String dates;
	private String times;
	private String buildingAndRoom;
	
	/**
	 * C'tor which does a deep copy any IBlockCourse-implementation into a BlockCourse.
	 * @param course an IBlockCourse implementation
	 */
	public BlockCourse(IBlockCourse course) {
		this.id = course.getId();
		
		this.courseOfStudies = course.getCourseOfStudies();
		
		this.lectureName = course.getLectureName();
		this.lecturerNames = course.getLecturerNames();
		this.dates = course.getDates();
		this.times = course.getTimes();
		this.buildingAndRoom = course.getBuildingAndRoom();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getId() {
		return id;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Course> getCourseOfStudies() {
		return courseOfStudies;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLectureName() {
		return lectureName;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLecturerNames() {
		return lecturerNames;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDates() {
		return dates;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTimes() {
		return times;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBuildingAndRoom() {
		return buildingAndRoom;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCourseOfStudies(List<Course> courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLecturerNames(String lecturerNames) {
		this.lecturerNames = lecturerNames;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDates(String dates) {
		this.dates = dates;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTimes(String times) {
		this.times = times;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBuildingAndRoom(String buildingAndRoom) {
		this.buildingAndRoom = buildingAndRoom;
	}	
}
