package de.hska.iwi.mgwt.demo.backend.model;

import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHour;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;

public class ConsultationHour implements IConsultationHour {
	
	private int id;
	
	private String firstname;
	private String lastname;
	private String title;
	private String adsAccount;
	private String mailAddress;
	private String consultationTime;
	private String room;
	private String building;
	
	private int consultationDay;

	public ConsultationHour(IConsultationHour hour) {
		this.id = hour.getId();
		this.firstname = hour.getFirstname();
		this.lastname = hour.getLastname();
		this.title = hour.getTitle();
		this.adsAccount = hour.getAdsAccount();
		this.mailAddress = hour.getMailAddress();
		this.consultationTime = hour.getConsultationTime();
		this.room = hour.getRoom();
		this.building = hour.getBuilding();
		
		this.consultationDay = hour.getConsultationDay();
	}

	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * @return the firstname
	 */
	@Override
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	@Override
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the title
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * @return the adsAccount
	 */
	@Override
	public String getAdsAccount() {
		return adsAccount;
	}

	/**
	 * @return the mailAddress
	 */
	@Override
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @return the consultationDay
	 */
	@Override
	public int getConsultationDay() {
		return consultationDay;
	}
	
	public Weekday getConsultationWeekday() {
		return Weekday.getEnumForKey(this.consultationDay);
	}

	/**
	 * @return the consultationTime
	 */
	@Override
	public String getConsultationTime() {
		return consultationTime;
	}

	/**
	 * @return the room
	 */
	@Override
	public String getRoom() {
		return room;
	}
	
	/**
	 * @return the building
	 */
	@Override
	public String getBuilding() {
		return building;
	}

	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param firstname the firstname to set
	 */
	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param title the title to set
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param adsAccount the adsAccount to set
	 */
	@Override
	public void setAdsAccount(String adsAccount) {
		this.adsAccount = adsAccount;
	}

	/**
	 * @param mailAddress the mailAddress to set
	 */
	@Override
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @param consultationDay the consultationDay to set
	 */
	@Override
	public void setConsultationDay(int consultationDay) {
		this.consultationDay = consultationDay;
	}
	
	public void setConsultationDay(Weekday consultationDay) {
		this.consultationDay = consultationDay.getNumberOfWeekday();
	}
	
	/**
	 * @param consultationTime the consultationTime to set
	 */
	@Override
	public void setConsultationTime(String consultationTime) {
		this.consultationTime = consultationTime;
	}

	/**
	 * @param room the room to set
	 */
	@Override
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * @param building the building to set
	 */
	@Override
	public void setBuilding(String building) {
		this.building = building;
	}
}
