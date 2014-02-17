package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum WorkflowStatusEnum {
	
	@PropertyName("O")
	DOCUMENTS_NOT_YET_CHECKED('O', "Die Dokumente wurden noch nicht geprüft."),
	@PropertyName("D")
	DOCUMENTS_DECLINED('D', "Die Dokumente wurden abgelehnt."),
	@PropertyName("A")
	DOCUMENTS_ACCEPTED('A', "Die Dokumente wurden akzeptiert."),
	@PropertyName("-")
	DEFAULT('-', "Es wurde noch kein Dokument hochgeladen");
	
	private final char key;
	private final String description;
	
	private WorkflowStatusEnum(char ch, String description) {
		this.key = ch;
		this.description = description;
	}

	public static WorkflowStatusEnum getEnumForKey(char key) {
		for (WorkflowStatusEnum status : WorkflowStatusEnum.values()) {
			if (status.getKey() == key) {
				return status;
			}
		}
		return WorkflowStatusEnum.DEFAULT;
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
	
	

}
