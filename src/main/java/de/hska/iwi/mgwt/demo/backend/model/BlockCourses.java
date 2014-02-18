package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IBlockCourse;
import de.hska.iwi.mgwt.demo.backend.autobean.IBlockCourses;

public class BlockCourses {

	private List<BlockCourse> courses;
	
	public BlockCourses(IBlockCourses blockCourses) {
		courses = new ArrayList<BlockCourse>();
		for (IBlockCourse course : blockCourses.getCourses()) {
			courses.add(new BlockCourse(course));
		}
	}

	/**
	 * @return the courses
	 */
	public List<BlockCourse> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<BlockCourse> courses) {
		this.courses = courses;
	}
	
	
}
