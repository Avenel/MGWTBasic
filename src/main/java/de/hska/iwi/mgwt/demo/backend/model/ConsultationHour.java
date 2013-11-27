package de.hska.iwi.mgwt.demo.backend.model;

import de.hska.iwi.mgwt.demo.backend.constants.Weekday;
import de.hska.iwi.mgwt.demo.backend.util.TimePeriod;

public class ConsultationHour {
	
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String title;
	
	private String adsAccount;
	
	private String mailAddress;
	
	private Weekday consultationDay;
	
	private TimePeriod consultationTime;
	
	private int room;
	
	private String building;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the adsAccount
	 */
	public String getAdsAccount() {
		return adsAccount;
	}

	/**
	 * @return the mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @return the consultationDay
	 */
	public Weekday getConsultationDay() {
		return consultationDay;
	}

	/**
	 * @return the consultationTime
	 */
	public TimePeriod getConsultationTime() {
		return consultationTime;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param adsAccount the adsAccount to set
	 */
	public void setAdsAccount(String adsAccount) {
		this.adsAccount = adsAccount;
	}

	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @param consultationDay the consultationDay to set
	 */
	public void setConsultationDay(Weekday consultationDay) {
		this.consultationDay = consultationDay;
	}
	
	/**
	 * @param consultationTime the consultationTime to set
	 */
	public void setConsultationTime(TimePeriod consultationTime) {
		this.consultationTime = consultationTime;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
}
