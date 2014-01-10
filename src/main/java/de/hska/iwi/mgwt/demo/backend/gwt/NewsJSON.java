package de.hska.iwi.mgwt.demo.backend.gwt;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;

public interface NewsJSON {
	
	public int getId();
	
	public String getTitle();
	
	public String getSubTitle();
	
	public List<Course> getCourseOfStudies();
	
	public String getContent();
	
	public List<String> getLinks();
	
	public NewsType getType();
	
	public void setId(int id);
	
	public void setTitle(String title);
	
	public void setSubTitle(String subTitle);
	
	public void setCourseOfStudies(List<Course> courseOfStudies);
	
	public void setContent(String content);
	
	public void setLinks(List<String> links);
	
	public void setType(NewsType type);

}
