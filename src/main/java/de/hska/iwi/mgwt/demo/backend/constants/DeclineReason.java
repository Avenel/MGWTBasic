package de.hska.iwi.mgwt.demo.backend.constants;

public enum DeclineReason {
	
	DEFAULT(-1, "Kein Status vorhanden"),
	STUDENTS_WISH(0, "Die Abmeldung erfolgt auf Wunsch des Studierenden."),
	NOT_AGREED(1, "Das Thema war nicht im Vorfeld abgestimmt worden."),
	MISSED_DEADLINE(2, "Die Anmeldefrist war bereits verstrichen."),
	TOPIC_NOT_REASONABLE(3, "Das Thema ist nicht akzeptabel."),
	TASKDESCRIPTION_NOT_REASONABLE(4, "Die Aufgabenbeschreibung ist nicht akzeptabel oder ausreichend."),
	PRECONDITION_NOT_FULFILLED(5, "Eine Vorbedingung der Prüfungsordnung ist nicht erfüllt."),
	COMPANY_NOT_ACCEPTED(6, "Die Firma betreut schon zu viele Arbeiten oder ist nicht geeignet."),
	CONSULTATION_WITH_ADVISOR(7, "Es ist eine Rücksprache mit dem Betreuer erforderlich."),
	MISSING_DOCUMENTS(8, "Es fehlen noch Unterlagen bzw. die vorgelegten sind lückenhaft.");
	
	private final int key;
	
	private final String description;
	
	private DeclineReason(int key, String description) {
		this.key = key;
		this.description = description;
	}
	
	public static DeclineReason getEnumForKey(int key) {
		for (DeclineReason reason : DeclineReason.values()) {
			if (reason.getKey() == key) {
				return reason;
			}
		}
		return DeclineReason.DEFAULT;
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	@Override
	public String toString() {
		return this.description;
	}

}
