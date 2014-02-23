package de.hska.iwi.mgwt.demo.client.model;

/**
 * Enum for the possible mensa price categories.
 * @author Martin
 *
 */
public enum MensaPriceCategory implements HumanReadableEnum {
	STUDENT("Student"), EMPLOYEE("Mitarbeiter"), PUPIL("Schüler"), GUEST("Gast");
	
	private String humanReadableName;
	
	/**
	 * Private constructor. Setup human readable name.
	 * @param humanReadableName
	 */
	private MensaPriceCategory(String humanReadableName) {
		this.humanReadableName = humanReadableName;
	}
	
	/**
	 * Returns MensaPriceCategory instance for a given category name.
	 * @param category
	 * @return MensaPriceCategory instance
	 */
	public static MensaPriceCategory getByString(String category) {
		MensaPriceCategory returnValue = STUDENT;
		
		if (category.compareTo(STUDENT.getHumanReadableName()) == 0) return STUDENT;
		if (category.compareTo(EMPLOYEE.getHumanReadableName()) == 0) return EMPLOYEE;
		if (category.compareTo(PUPIL.getHumanReadableName()) == 0) return PUPIL;
		if (category.compareTo(GUEST.getHumanReadableName()) == 0) return GUEST;
		
		return returnValue;
	}

	@Override
	public String getHumanReadableName() {
		return this.humanReadableName;
	}

	@Override
	public void setHumanReadableName(String name) {
		this.humanReadableName = name;
	}
	
}
