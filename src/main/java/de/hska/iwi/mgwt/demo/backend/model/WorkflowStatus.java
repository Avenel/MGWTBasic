package de.hska.iwi.mgwt.demo.backend.model;

import java.util.Map;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;

public class WorkflowStatus {
	
	private WorkflowPhase phase;
	
	private String phaseString;
	
	public WorkflowStatus(IWorkflowStatus iStatus) {
		for (Map.Entry<WorkflowPhase, String> entry : iStatus.getWorkflowStatus().entrySet()) {
			this.phase = entry.getKey();
			this.phaseString = entry.getValue();
		}
	}

	/**
	 * @return the phase
	 */
	public WorkflowPhase getPhase() {
		return phase;
	}
	
	public String getPhaseDescription() {
		phase.parseStatus(phaseString);
		return phase.getPhaseDescription();
	}

	/**
	 * @return the phaseDescription
	 */
	public String getPhaseString() {
		return phaseString;
	}

}
