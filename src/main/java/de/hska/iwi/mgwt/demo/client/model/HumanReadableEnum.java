package de.hska.iwi.mgwt.demo.client.model;

/**
 * Interface for enums which have, besides their "enum name", a human readable name.
 * Use this interface, if you want to display the enum in the gui.  
 * @author Martin
 *
 */
public interface HumanReadableEnum {

	public String getHumanReadableName();
	
	public void setHumanReadableName(String name);
	
}
