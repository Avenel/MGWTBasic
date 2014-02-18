package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IBlockCourse;
import de.hska.iwi.mgwt.demo.backend.constants.Course;

public class BlockCourse implements IBlockCourse {
	
	private int id;
	
	private List<Course> courseOfStudies;
	
	private String lectureName;
	//perhaps a list of Strings, if all lectureres are lists, currently they are just a simple long String seperated by a comma
	private String lecturerNames;
	private String dates;
	private String times;
	private String buildingAndRoom;
	
	public BlockCourse(IBlockCourse course) {
		this.id = course.getId();
		
		this.courseOfStudies = course.getCourseOfStudies();
		
		this.lectureName = course.getLectureName();
		this.lecturerNames = course.getLecturerNames();
		this.dates = course.getDates();
		this.times = course.getTimes();
		this.buildingAndRoom = course.getBuildingAndRoom();
	}
	
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getCourseOfStudies()
	 */
	@Override
	public List<Course> getCourseOfStudies() {
		return courseOfStudies;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getLectureName()
	 */
	@Override
	public String getLectureName() {
		return lectureName;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getLecturerNames()
	 */
	@Override
	public String getLecturerNames() {
		return lecturerNames;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getDates()
	 */
	@Override
	public String getDates() {
		return dates;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getTimes()
	 */
	@Override
	public String getTimes() {
		return times;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#getBuildingAndRoom()
	 */
	@Override
	public String getBuildingAndRoom() {
		return buildingAndRoom;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setCourseOfStudies(java.util.List)
	 */
	@Override
	public void setCourseOfStudies(List<Course> courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setLectureName(java.lang.String)
	 */
	@Override
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setLecturerNames(java.lang.String)
	 */
	@Override
	public void setLecturerNames(String lecturerNames) {
		this.lecturerNames = lecturerNames;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setDates(java.lang.String)
	 */
	@Override
	public void setDates(String dates) {
		this.dates = dates;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setTimes(java.lang.String)
	 */
	@Override
	public void setTimes(String times) {
		this.times = times;
	}
	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ITest#setBuildingAndRoom(java.lang.String)
	 */
	@Override
	public void setBuildingAndRoom(String buildingAndRoom) {
		this.buildingAndRoom = buildingAndRoom;
	}	
}
