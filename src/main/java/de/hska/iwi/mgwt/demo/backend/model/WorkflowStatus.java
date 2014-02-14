package de.hska.iwi.mgwt.demo.backend.model;

import java.util.Map;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;

public class WorkflowStatus {
	
	private WorkflowPhase phase;
	
	private int phaseKey;
	
	private String phaseDescription;
	
	public WorkflowStatus(IWorkflowStatus iStatus) {
		for (Map.Entry<WorkflowPhase, String> entry : iStatus.getWorkflowStatus().entrySet()) {
			this.phase = entry.getKey();
			this.phaseDescription = entry.getValue();
		}
	}

	/**
	 * @return the phase
	 */
	public int getPhaseKey() {
		return phaseKey;
	}
	
	

	/**
	 * @return the phase
	 */
	public WorkflowPhase getPhase() {
		return phase;
	}

	/**
	 * @return the phaseDescription
	 */
	public String getPhaseDescription() {
		return phaseDescription;
	}
}
