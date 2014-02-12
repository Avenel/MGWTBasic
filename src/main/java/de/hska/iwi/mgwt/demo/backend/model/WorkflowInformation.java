package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowInformation;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowRoles;

public class WorkflowInformation implements IWorkflowInformation {
	
	private List<String> workflow;
	
	private String applicationHint;
	
	private String uploadHint;
	
	private String noteHint;
	
	private String applicationDeadlineHint;
	
	private String uploadDeadlineHint;
	
	private String handOverDeadlineHint;
		
	public WorkflowInformation(IWorkflowInformation workflowInfo) {
		this.workflow = workflowInfo.getWorkflow();
		this.applicationHint = workflowInfo.getApplicationHint();
		this.uploadHint = workflowInfo.getUploadHint();
		this.noteHint = workflowInfo.getNoteHint();
		this.applicationDeadlineHint = workflowInfo.getApplicationDeadlineHint();
		this.uploadDeadlineHint = workflowInfo.getUploadDeadlineHint();
		this.handOverDeadlineHint = workflowInfo.getHandOverDeadlineHint();
	}
	
	public List<WorkflowRoles> getRolesInPhase(WorkflowPhase phase) {
		ArrayList<WorkflowRoles> roles = new ArrayList<WorkflowRoles>();

		for (char ch : this.workflow.get(phase.getIndex()).toCharArray()) {
			roles.add(WorkflowRoles.getEnumForKey(ch));
		}
		
		return roles;
	}

	@Override
	public List<String> getWorkflow() {
		return this.workflow;
	}

	@Override
	public void setWorkflow(List<String> workflow) {
		this.workflow = workflow;
	}

	@Override
	public String getApplicationHint() {
		return this.applicationHint;
	}

	@Override
	public void setApplicationHint(String applicationHint) {
		this.applicationHint = applicationHint;
	}

	@Override
	public String getUploadHint() {
		return this.uploadHint;
	}

	@Override
	public void setUploadHint(String uploadHint) {
		this.uploadHint = uploadHint;
	}

	@Override
	public String getNoteHint() {
		return this.noteHint;
	}

	@Override
	public void setNoteHint(String noteHint) {
		this.noteHint = noteHint;
	}

	@Override
	public String getApplicationDeadlineHint() {
		return this.applicationDeadlineHint;
	}

	@Override
	public void setApplicationDeadlineHint(String applicationDeadlineHint) {
		this.applicationDeadlineHint = applicationDeadlineHint;
	}

	@Override
	public String getUploadDeadlineHint() {
		return this.uploadDeadlineHint;
	}

	@Override
	public void setUploadDeadlineHint(String uploadDeadlineHint) {
		this.uploadDeadlineHint = uploadDeadlineHint;
	}

	@Override
	public String getHandOverDeadlineHint() {
		return this.handOverDeadlineHint;
	}

	@Override
	public void setHandOverDeadlineHint(String handOverDeadlineHint) {
		this.handOverDeadlineHint = handOverDeadlineHint;
	}

}
