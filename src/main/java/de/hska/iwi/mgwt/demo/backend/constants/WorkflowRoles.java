package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum WorkflowRoles {
	@PropertyName("A")
	APPLICATION_THROUGH_STUDENT('A', "Anmeldung durch einen Studierenden"),
	@PropertyName("p")
	PRIMARY_ASSESSOR('p', "Erstgutachter muss es nur zur Kenntniss nehmen"),
	@PropertyName("P")
	PRIMARY_ASSESSOR_APPROVAL('P', "Erstgutachter muss zustimmen"),
	@PropertyName("s")
	SECONDARY_ASSESSOR('s', "Zweitgutachter muss es nur zur Kenntniss nehmen"),
	@PropertyName("S")
	SECONDARY_ASSESSOR_APPROVAL('S', "Zweitgutachter muss zustimmen"),
	@PropertyName("o")
	SECRETARIAT('o', "Sekretariat muss es nur zur Kenntniss nehmen"),
	@PropertyName("O")
	SECRETARIAT_APPROVAL('O', "Sekretariat muss zustimmen"),
	@PropertyName("h")
	HEAD_OF_EVENT('h', "Leiter der Veranstaltung muss es nur zur Kenntniss nehmen"),
	@PropertyName("H")
	HEAD_OF_EVENT_APPROVAL('H', "Leiter der Veranstaltung muss zustimmen"),
	@PropertyName("U")
	UPLOAD_OF_RESULTS('U', "Hochladen von Ergebnissen"),
	@PropertyName("N")
	MARK_CAN_SEEN_BY_STUDENT('N', "Note kann vom Studierenden eingesehen werden");
	
	private char key;
	
	private String description;
	
	private WorkflowRoles(char key, String description) {
		this.key = key;
		this.description = description;

	}
	
	public char getKey() {
		return this.key;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static WorkflowRoles getEnumForKey(char key) {
		for (WorkflowRoles role : WorkflowRoles.values()) {
			if (role.getKey() == key) {
				return role;
			}
		}
		return APPLICATION_THROUGH_STUDENT;
	}

}
