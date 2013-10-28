package de.hska.iwi.mgwt.demo.client.model;

public class MenuItem {
	
	private String id;
	private String displayText;
	
	public MenuItem(String id, String displayText){
		this.id= id;
		this.displayText= displayText;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

}
