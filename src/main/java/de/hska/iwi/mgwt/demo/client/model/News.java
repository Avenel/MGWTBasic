package de.hska.iwi.mgwt.demo.client.model;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;

public class News {
	
	private String id;
	private String title;
	private String content;
	private String organisation;
	private Date date;
	
	/**
	 * Setters and getters
	 */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static News fromJson(JSONObject value) {
		News news = new News();
		
		news.id = value.get("id").isNumber().toString();
		news.title = value.get("title").isString().stringValue();
		news.content = value.get("content").isString().stringValue();
		news.organisation = value.get("organisation").isString().stringValue();

		DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy-MM-d");
		String newsDate = value.get("date").toString();
		newsDate = newsDate.replace('\"', ' ').trim();
		news.date = fmt.parse(newsDate);
		return news;
	}

}
