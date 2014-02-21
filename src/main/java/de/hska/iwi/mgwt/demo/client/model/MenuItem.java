package de.hska.iwi.mgwt.demo.client.model;

/**
 * The Model for a menu item in a menu. A menu item is a choice in a menu, that
 * a user can make to process a workflow.
 * 
 * @author Simon
 * 
 */
public class MenuItem {
	/**
	 * The id of the MenuItem. This can be any String
	 */
	private String id;
	/**
	 * The displayText of the MenuItem. This should be used to represent the
	 * item in a menu (usually shown to the user) and therefore should be
	 * something short, useful and concise to the user
	 */
	private String displayText;
	/**
	 * This type of the MenuItem. This can be any String
	 */
	private String type;

	/**
	 * Constructor
	 * 
	 * @param id
	 *            the id of the MenuItem. This can be any String
	 * @param displayText
	 *            The displayText of the MenuItem. This should be used to
	 *            represent the item in a menu (usually shown to the user) and
	 *            therefore should be something short, useful and concise to the
	 *            user
	 * @param type
	 *            This type of the MenuItem. This can be any String
	 */
	public MenuItem(String id, String displayText, String type) {
		this.id = id;
		this.displayText = displayText;
		this.type = type;
	}
/**
 * Gets the id of a MenuItem
 * @return the id as a String.
 */
	public String getId() {
		return id;
	}
	/**
	 * Sets the id of a MenuItem
	 * @param id the id as a String. Can be any String
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Gets the DisplayText of a MenuItem. 
	 * @return the DisplayText of a MenuItem
	 */
	public String getDisplayText() {
		return displayText;
	}
	/**
	 * Sets the displayText of a MenuItem
	 * @param displayText This should be used to
	 *            represent the item in a menu (usually shown to the user) and
	 *            therefore should be something short, useful and concise to the
	 *            user
	 */
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	/**
	 * Gets the type of MenuItem.
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Sets the type of a MenuItem.
	 * @param type The type. This could be any String
	 */
	public void setType(String type) {
		this.type = type;
	}

}
