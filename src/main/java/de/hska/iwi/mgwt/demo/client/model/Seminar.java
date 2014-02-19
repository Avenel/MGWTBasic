package de.hska.iwi.mgwt.demo.client.model;

/**
 * Represents a Seminar. 
 * @author Simon
 *
 */
public class Seminar {
	private String professor;
	private String topic;
	private String term;
	private int status;
	private String statusString;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getStatusString(){
		return this.statusString;
	}
	public void setStatusString(String text){
		this.statusString=text;
	}
	
}
