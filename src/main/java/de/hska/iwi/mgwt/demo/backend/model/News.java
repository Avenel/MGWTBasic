package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.INews;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;

public class News implements INews {
	
	private int id;
	
	private String title;
	
	private String subTitle;
	
	private List<Course> courseOfStudies;
	
	private String content;
	
	private List<String> links;
	
	private NewsType type;
	
	public News() {
		
	}
	
	public News(INews currNews) {
		this.content = currNews.getContent();
		this.courseOfStudies = currNews.getCourseOfStudies();
		this.id = currNews.getId();
		this.links = currNews.getLinks();
		this.subTitle = currNews.getSubTitle();
		this.title = currNews.getTitle();
		this.type = currNews.getType();
	}

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
		if (courseOfStudies == null) {
			ArrayList<Course> studies = new ArrayList<Course>();
			studies.add(Course.ALL);
			courseOfStudies = studies;
		}
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
