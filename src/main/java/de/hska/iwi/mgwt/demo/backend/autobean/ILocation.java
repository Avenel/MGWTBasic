package de.hska.iwi.mgwt.demo.backend.autobean;

public interface ILocation {

	/**
	 * @return the building
	 */
	public String getBuilding();

	/**
	 * @return the room
	 */
	public String getRoom();

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building);

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room);

}