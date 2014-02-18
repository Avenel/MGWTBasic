package de.hska.iwi.mgwt.demo.backend.model;

import de.hska.iwi.mgwt.demo.backend.autobean.ILocation;

public class Location implements ILocation {
	
	private String building;
	
	private String room;
	
	public Location(ILocation iLoc) {
		this.building = iLoc.getBuilding();
		this.room = iLoc.getRoom();
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ILocation#getBuilding()
	 */
	@Override
	public String getBuilding() {
		return building;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ILocation#getRoom()
	 */
	@Override
	public String getRoom() {
		return room;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ILocation#setBuilding(java.lang.String)
	 */
	@Override
	public void setBuilding(String building) {
		this.building = building;
	}

	/* (non-Javadoc)
	 * @see de.hska.iwi.mgwt.demo.backend.model.ILocation#setRoom(java.lang.String)
	 */
	@Override
	public void setRoom(String room) {
		this.room = room;
	}

}
