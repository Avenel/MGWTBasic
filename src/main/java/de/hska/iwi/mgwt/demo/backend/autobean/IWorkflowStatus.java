package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.Map;

import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;

public interface IWorkflowStatus {
	
	public Map<WorkflowPhase, String> getWorkflowStatus();
	
	public void setWorkflowStatus(Map<WorkflowPhase, String> status);

}
