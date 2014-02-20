package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;

public interface INews {
	/**
	 * @return the id
	 */
	public int getId();
	/**
	 * @return the title
	 */
	public String getTitle();
	/**
	 * @return the subTitle
	 */
	public String getSubTitle();
	/**
	 * Returns the list of Courses for this News, if it is empty, than it will be represented by one entry with Course.All
	 * @return the courseOfStudies
	 */
	public List<Course> getCourseOfStudies();
	/**
	 * @return the content
	 */
	public String getContent();
	/**
	 * @return the links
	 */
	public List<String> getLinks();
	/**
	 * @return the type
	 */
	public NewsType getType();
	/**
	 * @param id the id to set
	 */
	public void setId(int id);
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title);
	/**
	 * @param subTitle the subTitle to set
	 */
	public void setSubTitle(String subTitle);
	/**
	 * @param courseOfStudies the courseOfStudies to set
	 */
	public void setCourseOfStudies(List<Course> courseOfStudies);
	/**
	 * @param content the content to set
	 */
	public void setContent(String content);
	/**
	 * @param links the links to set
	 */
	public void setLinks(List<String> links);
	/**
	 * @param type the type to set
	 */
	public void setType(NewsType type);

}
