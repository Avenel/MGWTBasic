package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;
import de.hska.iwi.mgwt.demo.backend.gwt.NewsJSON;

public class NewsBoard implements NewsJSON{
	
	private int id;
	
	private String title;
	
	private String subTitle;
	
	private List<Course> courseOfStudies;
	
	private String content;
	
	private List<String> links;
	
	private NewsType type;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the subTitle
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * @return the courseOfStudies
	 */
	public List<Course> getCourseOfStudies() {
		return courseOfStudies;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the links
	 */
	public List<String> getLinks() {
		return links;
	}

	/**
	 * @return the type
	 */
	public NewsType getType() {
		return type;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param subTitle the subTitle to set
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * @param courseOfStudies the courseOfStudies to set
	 */
	public void setCourseOfStudies(List<Course> courseOfStudies) {
		this.courseOfStudies = courseOfStudies;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(List<String> links) {
		this.links = links;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(NewsType type) {
		this.type = type;
	}

}
