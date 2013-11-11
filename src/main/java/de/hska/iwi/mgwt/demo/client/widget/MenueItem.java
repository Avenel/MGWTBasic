package de.hska.iwi.mgwt.demo.client.widget;

/**
 * Represents a simple menue item with title and icon.
 * @author Martin
 *
 */
public class MenueItem {

	private String title;
	private String iconURL;
	
	public MenueItem(String title, String iconURL) {
		super();
		this.title = title;
		this.iconURL = iconURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	
	
	
}
