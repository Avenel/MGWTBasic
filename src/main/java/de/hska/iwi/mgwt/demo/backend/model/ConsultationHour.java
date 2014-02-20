package de.hska.iwi.mgwt.demo.backend.model;

import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHour;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;
/**
 * Model class for ConsultationHour, holds the provided data and adds some additional fuctionality.
 * @author Nico
 *
 */
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

	/**
	 * C'tor which creates a deep copy of the given Interface implementation.
	 * @param hour the given Implementation 
	 */
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
	 * {@inheritDoc}
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFirstname() {
		return firstname;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLastname() {
		return lastname;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAdsAccount() {
		return adsAccount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getConsultationDay() {
		return consultationDay;
	}
	/**
	 * 
	 * @return the consultationDay as a {@link Weekday}-Enum
	 */
	public Weekday getConsultationWeekday() {
		return Weekday.getEnumForKey(this.consultationDay);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getConsultationTime() {
		return consultationTime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRoom() {
		return room;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBuilding() {
		return building;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAdsAccount(String adsAccount) {
		this.adsAccount = adsAccount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setConsultationDay(int consultationDay) {
		this.consultationDay = consultationDay;
	}
	/**
	 * 
	 * @param consultationDay a {@link Weekday}-enum which sets the consultationDay
	 */
	public void setConsultationDay(Weekday consultationDay) {
		this.consultationDay = consultationDay.getNumberOfWeekday();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setConsultationTime(String consultationTime) {
		this.consultationTime = consultationTime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBuilding(String building) {
		this.building = building;
	}
}
