package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.user.client.ui.IsWidget;

public interface NewsDetailView extends IsWidget {
	
	public void setTitle(String title);
	public void setContent(String content);
}
