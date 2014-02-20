package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowInformation;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowRoles;
/**
 * Model class for the WorkflowInformation. This holds information about an Workflow for an event, like the deadline etc.
 * @author Nico
 *
 */
public class WorkflowInformation implements IWorkflowInformation {
	
	private List<String> workflow;
	
	private String applicationHint;
	private String uploadHint;
	private String noteHint;
	private String applicationDeadlineHint;
	private String uploadDeadlineHint;
	private String handOverDeadlineHint;
		
	/**
	 * C'tor which creates a deep copy of the given Interface type.
	 * @param workflowInfo the given interface implementation type.
	 */
	public WorkflowInformation(IWorkflowInformation workflowInfo) {
		this.workflow = workflowInfo.getWorkflow();
		this.applicationHint = workflowInfo.getApplicationHint();
		this.uploadHint = workflowInfo.getUploadHint();
		this.noteHint = workflowInfo.getNoteHint();
		this.applicationDeadlineHint = workflowInfo.getApplicationDeadlineHint();
		this.uploadDeadlineHint = workflowInfo.getUploadDeadlineHint();
		this.handOverDeadlineHint = workflowInfo.getHandOverDeadlineHint();
	}
	
	/**
	 * 
	 * @param phase the {@link WorkflowPhase} for that the single roles are requested
	 * @return list of all the Roles which are taking part in this phase
	 */
	public List<WorkflowRoles> getRolesInPhase(WorkflowPhase phase) {
		ArrayList<WorkflowRoles> roles = new ArrayList<WorkflowRoles>();

		for (char ch : this.workflow.get(phase.getIndex()).toCharArray()) {
			roles.add(WorkflowRoles.getEnumForKey(ch));
		}
		
		return roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getWorkflow() {
		return workflow;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApplicationHint() {
		return applicationHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUploadHint() {
		return uploadHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNoteHint() {
		return noteHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApplicationDeadlineHint() {
		return applicationDeadlineHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUploadDeadlineHint() {
		return uploadDeadlineHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHandOverDeadlineHint() {
		return handOverDeadlineHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWorkflow(List<String> workflow) {
		this.workflow = workflow;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationHint(String applicationHint) {
		this.applicationHint = applicationHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUploadHint(String uploadHint) {
		this.uploadHint = uploadHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNoteHint(String noteHint) {
		this.noteHint = noteHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationDeadlineHint(String applicationDeadlineHint) {
		this.applicationDeadlineHint = applicationDeadlineHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setUploadDeadlineHint(String uploadDeadlineHint) {
		this.uploadDeadlineHint = uploadDeadlineHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHandOverDeadlineHint(String handOverDeadlineHint) {
		this.handOverDeadlineHint = handOverDeadlineHint;
	}
}
