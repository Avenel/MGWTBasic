package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum WorkflowPhase {
	@PropertyName("0")
	APPLICATION(0),
	@PropertyName("1")
	APPROVAL(1),
	@PropertyName("2")
	UPLOAD(2),
	@PropertyName("3")
	LECTURER_AUDIT(3),
	@PropertyName("4")
	MARK_FILL_IN(4),
	@PropertyName("5")
	MARK_ACCESS(5);
	
	private final int index;
	
	private WorkflowPhase(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}

}
