package de.hska.iwi.mgwt.demo.backend.constants;
/**
 * Enum values for the different Roles which taking place in a WorkflowPhase. Specified in the REST-API.
 * @author Nico
 *
 */
public enum WorkflowRoles {

	APPLICATION_THROUGH_STUDENT('A', "Anmeldung durch einen Studierenden"),
	PRIMARY_ASSESSOR('p', "Erstgutachter muss es nur zur Kenntniss nehmen"),
	PRIMARY_ASSESSOR_APPROVAL('P', "Erstgutachter muss zustimmen"),
	SECONDARY_ASSESSOR('s', "Zweitgutachter muss es nur zur Kenntniss nehmen"),
	SECONDARY_ASSESSOR_APPROVAL('S', "Zweitgutachter muss zustimmen"),
	SECRETARIAT('o', "Sekretariat muss es nur zur Kenntniss nehmen"),
	SECRETARIAT_APPROVAL('O', "Sekretariat muss zustimmen"),
	HEAD_OF_EVENT('h', "Leiter der Veranstaltung muss es nur zur Kenntniss nehmen"),
	HEAD_OF_EVENT_APPROVAL('H', "Leiter der Veranstaltung muss zustimmen"),
	UPLOAD_OF_RESULTS('U', "Hochladen von Ergebnissen"),
	MARK_CAN_SEEN_BY_STUDENT('N', "Note kann vom Studierenden eingesehen werden"),
	APPLICATION_DECLINED('D', "Die Anmeldung wurde abgelehnt."),
	DEFAULT('-', "No more information");
	
	private char key;
	
	private String description;
	
	private WorkflowRoles(char key, String description) {
		this.key = key;
		this.description = description;

	}
	/**
	 * @return the key
	 */
	public char getKey() {
		return key;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Factory-method which creates an Enum from a given key.
	 * @param key the character which shall be referenced by an Enum.
	 * @return The corresponding Enum which is represented by the given key
	 */
	public static WorkflowRoles getEnumForKey(char key) {
		for (WorkflowRoles role : WorkflowRoles.values()) {
			if (role.getKey() == key) {
				return role;
			}
		}
		return APPLICATION_THROUGH_STUDENT;
	}
	
	@Override
	public String toString() {
		return this.description;
	}

}
