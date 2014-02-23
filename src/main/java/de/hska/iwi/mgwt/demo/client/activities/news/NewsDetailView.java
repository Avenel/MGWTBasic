package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * Interface for NewsDetail view.
 * @author Martin
 *
 */
public interface NewsDetailView extends IsWidget {
	
	/**
	 * Setter for title in Headerbar.
	 * @param title
	 */
	public void setTitle(String title);
	
	/**
	 * Setter for news content.
	 * @param content
	 */
	public void setContent(String content);
}
