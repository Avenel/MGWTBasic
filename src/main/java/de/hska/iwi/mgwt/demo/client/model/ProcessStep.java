package de.hska.iwi.mgwt.demo.client.model;

public class ProcessStep {
	
	String displayText;
	int stepIndex;
	
	
	
	public ProcessStep( String displayText, int stepIndex){
		this.displayText=displayText;
		this.stepIndex=stepIndex;
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
	
	
}

