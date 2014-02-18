package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum WorkflowPhase implements ITransitions {
	@PropertyName("0")
	APPLICATION(0, "Anmeldephase") {
		@Override
		public void parseStatus(String status) {
			if (WorkflowStatusEnum.DEFAULT == WorkflowStatusEnum.getEnumForKey(status.charAt(PRIMARY_INDEX))) {
				phaseDescription = "Du hast dich noch nie für diese Arbeit angemeldet";
			}
		}
	},
	@PropertyName("1")
	APPROVAL(1, "Genehmigungsphase") {
		@Override
		public void parseStatus(String status) {
			WorkflowRoles role = WorkflowRoles.getEnumForKey(status.charAt(PRIMARY_INDEX));
			switch (role) {
				case APPLICATION_DECLINED:
					phaseDescription = (DeclineReason.getEnumForKey(status.charAt(SECONDARY_INDEX))).getDescription();
					break;
				default:
					phaseDescription = role.getDescription();
			}
			
		}
	},
	@PropertyName("2")
	UPLOAD(2, "Hochladen von Ergebnissen") {
		@Override
		public void parseStatus(String status) {
			phaseDescription = WorkflowStatusEnum.DEFAULT.getDescription();
		}
	},
	@PropertyName("3")
	LECTURER_AUDIT(3, "Prüfung der Dokumente") {
		@Override
		public void parseStatus(String status) {
			WorkflowStatusEnum stat = WorkflowStatusEnum.getEnumForKey(status.charAt(PRIMARY_INDEX));
			phaseDescription = stat.getDescription();
		}
	},
	@PropertyName("4")
	MARK_FILL_IN(4, "Noteneingabe") {
		@Override
		public void parseStatus(String status) {
			WorkflowRoles role = WorkflowRoles.getEnumForKey(status.charAt(PRIMARY_INDEX));
			switch (role) {
				case DEFAULT:
					phaseDescription = "Die Note wurde noch nicht eingetragen";
					break;
				default:
					phaseDescription = role.getDescription();	
			}
			
		}
	},
	@PropertyName("5")
	MARK_ACCESS(5, "Notenansicht") {
		@Override
		public void parseStatus(String status) {
			phaseDescription = String.valueOf(Double.parseDouble(status) / 100);
			
		}
	};
	
	private final int index;
	
	private final String description;
	
	private static int PRIMARY_INDEX = 0;
	
	private static int SECONDARY_INDEX = 1;
	
	private static String phaseDescription = "";
	
	private WorkflowPhase(int index, String description) {
		this.index = index;
		this.description = description;
	}
	
	public int getIndex() {
		return this.index;
	}

	/**
	 * returns a textual description of a phase, for e.g. Phase 0 is associated with the Application Phase, this will return "Anmeldephase"
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * returns the description belonging to a students status, the current role which needs to perform the next step.
	 * example: Student is in 1:o1 then this will return a description what is to do next. "Sekretariat muss zustimmen" 
	 * @return
	 */
	public String getCurrentPhaseDescription() {
		return phaseDescription;
	}
	
	public static WorkflowPhase getEnumForKey(String key) {
		int intKey = Integer.parseInt(key);
		return getEnumForKey(intKey);
	}
	
	public static WorkflowPhase getEnumForKey(int key) {
		for (WorkflowPhase phase : WorkflowPhase.values()) {
			if (phase.getIndex() == key) {
				return phase;
			}
		}
		return WorkflowPhase.APPLICATION;
	}

	@Override
	public abstract void parseStatus(String status);
}
