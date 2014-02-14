package de.hska.iwi.mgwt.demo.backend.constants;

public enum WorkflowStatusEnum {
	
	DOCUMENTS_NOT_YET_CHECKED('O', "Die Dokumente wurden noch nicht geprüft."),
	DOCUMENTS_DECLINED('D', "Die Dokumente wurden abgelehnt."),
	DEFAULT('-', "Keine weiteren Informationen");
	
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
