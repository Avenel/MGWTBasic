package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IBlockCourses {

	/**
	 * @return the courses
	 */
	public List<IBlockCourse> getCourses();

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<IBlockCourse> courses);

}