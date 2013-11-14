package de.hska.iwi.mgwt.demo.client.model;

public class MenuItem {
	
	private String id;
	private String displayText;
	private String type; 
	
	
	public MenuItem(String id, String displayText, String type){
		this.id= id;
		this.displayText= displayText;
		this.type=type;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
