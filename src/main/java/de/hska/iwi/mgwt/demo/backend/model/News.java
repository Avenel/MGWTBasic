package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.INews;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;

/**
 * Model which holds information about a News, like the title, id, content etc.
 * @author Nico
 *
 */
public class News implements INews {
	
	private int id;
	
	private String title;
	private String content;
	private String subTitle;
	
	private List<Course> courseOfStudies;
	private List<String> links;
	
	private NewsType type;
	
	/**
	 * Default C'tor.
	 */
	public News() {
		
	}
	/**
	 * C'tor which creates a deep copy of the given Interface type.
	 * @param currNews the given interface implementation type.
	 */
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
	public String getTitle() {
		return title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Course> getCourseOfStudies() {
		if (courseOfStudies == null) {
			ArrayList<Course> studies = new ArrayList<Course>();
			studies.add(Course.ALL);
			courseOfStudies = studies;
		}
		return courseOfStudies;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getContent() {
		return content;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getLinks() {
		return links;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NewsType getType() {
		return type;
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
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLinks(List<String> links) {
		this.links = links;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setType(NewsType type) {
		this.type = type;
	}

}
