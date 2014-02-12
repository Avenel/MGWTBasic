package de.hska.iwi.mgwt.demo.backend.constants;

public enum WorkflowPhase {
	
	APPLICATION(0),
	APPROVAL(1),
	UPLOAD(2),
	LECTURER_AUDIT(3),
	MARK_FILL_IN(4),
	MARK_ACCESS(5);
	
	private final int index;
	
	private WorkflowPhase(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}

}
