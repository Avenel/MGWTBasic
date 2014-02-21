package de.hska.iwi.mgwt.demo.client.model;

/**
 * Represents a Seminar.
 * 
 * @author Simon
 * 
 */
public class Seminar {
	private String professor;
	private String topic;
	private String term;
	private int status;
	private String statusString;

	/**
	 * Gets the status of a Seminar.
	 * 
	 * @return The status, starting with 0
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status
	 * 
	 * @param status
	 *            The status. Start with 0
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets the lecturer supervising this seminar
	 * 
	 * @return The lecturer
	 */
	public String getProfessor() {
		return professor;
	}

	/**
	 * Sets the lecturer supervising this seminar
	 * 
	 * @param professor
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	/**
	 * Gets the topic of this seminar
	 * 
	 * @return The topic as a String
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Sets the topic
	 * 
	 * @param topic
	 *            The topic of this Seminar
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * Gets the term of this Seminar
	 * 
	 * @return The Term as a String
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * Sets the term of this Seminar
	 * 
	 * @param term
	 *            the term this seminar is held in
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * Gets the statusString
	 * 
	 * @return The String, that represents the current status
	 */
	public String getStatusString() {
		return this.statusString;
	}

	/**
	 * Sets the StatusString
	 * 
	 * @param text
	 *            The String to represent the current Status. This represents
	 *            the status and should be something useful to the user.
	 */
	public void setStatusString(String text) {
		this.statusString = text;
	}

}
