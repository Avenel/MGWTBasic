package de.hska.iwi.mgwt.demo.client.model;

public class ProcessStep {
	
	String displayText;
	int stepIndex;
	String description;
	
	
	
	public ProcessStep( String displayText, int stepIndex, String description){
		this.displayText=displayText;
		this.stepIndex=stepIndex;
		this.description=description;
	}
	
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public int getStepIndex() {
		return stepIndex;
	}
	public void setStepIndex(int stepIndex) {
		this.stepIndex = stepIndex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

