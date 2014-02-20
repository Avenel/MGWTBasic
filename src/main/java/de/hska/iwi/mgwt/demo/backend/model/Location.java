package de.hska.iwi.mgwt.demo.backend.model;

import de.hska.iwi.mgwt.demo.backend.autobean.ILocation;

/**
 * Model class for a Location, holds the information about such a Location-object.
 * @author Nico
 *
 */
public class Location implements ILocation {
	
	private String building;
	
	private String room;
	
	/**
	 * C#tor which creates a deep copy of the given interface implementation
	 * @param iLoc the interface implementation type
	 */
	public Location(ILocation iLoc) {
		this.building = iLoc.getBuilding();
		this.room = iLoc.getRoom();
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
	public String getRoom() {
		return room;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRoom(String room) {
		this.room = room;
	}

}
