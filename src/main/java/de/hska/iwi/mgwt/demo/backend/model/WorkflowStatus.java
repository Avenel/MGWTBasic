package de.hska.iwi.mgwt.demo.backend.model;

import de.hska.iwi.mgwt.demo.backend.autobean.IWorkflowStatus;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowPhase;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowStatusEnum;

public class WorkflowStatus implements IWorkflowStatus {
	
	private String topic;
	private String lecturer;
	private String dateOfIssue;
	private String dateOfHandOver;
	private String deadline;
	private String secondExaminer;
	private String workFlowState;
	
	private int attempt;
	private int overtime;
	
	private WorkflowStatusEnum resultFileUploadState;
	
	private WorkflowEvent type;
	
	private final WorkflowStateParser parser;

	public WorkflowStatus(IWorkflowStatus iState) {
		this.topic = iState.getTopic();
		this.lecturer = iState.getLecturer();
		this.dateOfIssue = iState.getDateOfIssue();
		this.dateOfHandOver = iState.getDateOfHandOver();
		this.deadline = iState.getDeadline();
		this.secondExaminer = iState.getSecondExaminer();
		this.workFlowState = iState.getWorkFlowState();
		
		this.attempt = iState.getAttempt();
		this.overtime = iState.getOvertime();
		
		this.resultFileUploadState = iState.getResultFileUploadState();
		
		this.type = iState.getType();
		
		this.parser = new WorkflowStateParser(iState.getWorkFlowState());
	}
	
	/**
	 * @return the phase of the current status of the student's event.
	 */
	public WorkflowPhase getPhase() {
		return parser.getPhase();
	}
	/**
	 * @return the description of the status of the current phase.
	 */
	public String getRoleDescription() {
		return parser.getRoleDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTopic() {
		return topic;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLecturer() {
		return lecturer;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDateOfHandOver() {
		return dateOfHandOver;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public String getDeadline() {
		return deadline;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSecondExaminer() {
		return secondExaminer;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public String getWorkFlowState() {
		return workFlowState;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public int getAttempt() {
		return attempt;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public int getOvertime() {
		return overtime;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WorkflowStatusEnum getResultFileUploadState() {
		return resultFileUploadState;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WorkflowEvent getType() {
		return type;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setDateOfHandOver(String dateOfHandOver) {
		this.dateOfHandOver = dateOfHandOver;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setSecondExaminer(String secondExaminer) {
		this.secondExaminer = secondExaminer;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setWorkFlowState(String workFlowState) {
		this.workFlowState = workFlowState;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setResultFileUploadState(WorkflowStatusEnum resultFileUploadState) {
		this.resultFileUploadState = resultFileUploadState;
	}
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public void setType(WorkflowEvent type) {
		this.type = type;
	}
	
	/**
	 * Parses the state of a given WorkflowState and creates the description string as well as the corressponding enum.
	 * Example: Given "„1:D2“ The reuslt will be the WorkflowPhase.UPLOAD with the corresponding description to D2 like "Die Anmeldefrist war bereits verstrichen."
	 * @author Nico
	 *
	 */
	private class WorkflowStateParser {
		
		private static final int PHASE_INDEX = 0;
		private static final int ROLE_INDEX = 1;
		
		private final WorkflowPhase phase;
		
		private final String roleDescription;
		
		/**
		 * C'tor which initializes the parser by the given a given stat. For example: „1:D2“ 
		 * @param workFlowState
		 */
		public WorkflowStateParser(String workFlowState) {
			String[] splitString = workFlowState.split(":");
			this.phase = WorkflowPhase.getEnumForKey(splitString[PHASE_INDEX]);
			this.phase.parseStatus(splitString[ROLE_INDEX]);
			this.roleDescription = phase.getCurrentPhaseDescription();
		}

		/**
		 * @return the phase
		 */
		public WorkflowPhase getPhase() {
			return phase;
		}

		/**
		 * @return the roleDescription
		 */
		public String getRoleDescription() {
			return roleDescription;
		}
	}
}
