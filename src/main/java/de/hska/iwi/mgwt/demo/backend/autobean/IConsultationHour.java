package de.hska.iwi.mgwt.demo.backend.autobean;


public interface IConsultationHour {

	/**
	 * @return the id
	 */
	public int getId();

	/**
	 * @return the firstname
	 */
	public String getFirstname();

	/**
	 * @return the lastname
	 */
	public String getLastname();

	/**
	 * @return the title
	 */
	public String getTitle();

	/**
	 * @return the adsAccount
	 */
	public String getAdsAccount();

	/**
	 * @return the mailAddress
	 */
	public String getMailAddress();

	/**
	 * @return the consultationDay
	 */
	public int getConsultationDay();

	/**
	 * @return the consultationTime
	 */
	public String getConsultationTime();

	/**
	 * @return the room
	 */
	public String getRoom();

	/**
	 * @return the building
	 */
	public String getBuilding();

	/**
	 * @param id the id to set
	 */
	public void setId(int id);

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname);

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname);

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title);

	/**
	 * @param adsAccount the adsAccount to set
	 */
	public void setAdsAccount(String adsAccount);

	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(String mailAddress);

	/**
	 * @param consultationDay the consultationDay to set
	 */
	public void setConsultationDay(int consultationDay);

	/**
	 * @param consultationTime the consultationTime to set
	 */
	public void setConsultationTime(String consultationTime);

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room);

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building);
}
