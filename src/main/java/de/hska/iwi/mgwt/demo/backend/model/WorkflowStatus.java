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
	
	public WorkflowPhase getPhase() {
		return parser.getPhase();
	}
	
	public String getRoleDescription() {
		return parser.getRoleDescription();
	}

	/**
	 * @return the topic
	 */
	@Override
	public String getTopic() {
		return topic;
	}


	/**
	 * @return the lecturer
	 */
	@Override
	public String getLecturer() {
		return lecturer;
	}


	/**
	 * @return the dateOfIssue
	 */
	@Override
	public String getDateOfIssue() {
		return dateOfIssue;
	}


	/**
	 * @return the dateOfHandOver
	 */
	@Override
	public String getDateOfHandOver() {
		return dateOfHandOver;
	}


	/**
	 * @return the deadline
	 */
	@Override
	public String getDeadline() {
		return deadline;
	}


	/**
	 * @return the secondExaminer
	 */
	@Override
	public String getSecondExaminer() {
		return secondExaminer;
	}


	/**
	 * @return the workFlowState
	 */
	@Override
	public String getWorkFlowState() {
		return workFlowState;
	}


	/**
	 * @return the attempt
	 */
	@Override
	public int getAttempt() {
		return attempt;
	}


	/**
	 * @return the overtime
	 */
	@Override
	public int getOvertime() {
		return overtime;
	}


	/**
	 * @return the resultFileUploadState
	 */
	@Override
	public WorkflowStatusEnum getResultFileUploadState() {
		return resultFileUploadState;
	}


	/**
	 * @return the type
	 */
	@Override
	public WorkflowEvent getType() {
		return type;
	}


	/**
	 * @param topic the topic to set
	 */
	@Override
	public void setTopic(String topic) {
		this.topic = topic;
	}


	/**
	 * @param lecturer the lecturer to set
	 */
	@Override
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}


	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	@Override
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}


	/**
	 * @param dateOfHandOver the dateOfHandOver to set
	 */
	@Override
	public void setDateOfHandOver(String dateOfHandOver) {
		this.dateOfHandOver = dateOfHandOver;
	}


	/**
	 * @param deadline the deadline to set
	 */
	@Override
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	/**
	 * @param secondExaminer the secondExaminer to set
	 */
	@Override
	public void setSecondExaminer(String secondExaminer) {
		this.secondExaminer = secondExaminer;
	}


	/**
	 * @param workFlowState the workFlowState to set
	 */
	@Override
	public void setWorkFlowState(String workFlowState) {
		this.workFlowState = workFlowState;
	}


	/**
	 * @param attempt the attempt to set
	 */
	@Override
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}


	/**
	 * @param overtime the overtime to set
	 */
	@Override
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}


	/**
	 * @param resultFileUploadState the resultFileUploadState to set
	 */
	@Override
	public void setResultFileUploadState(WorkflowStatusEnum resultFileUploadState) {
		this.resultFileUploadState = resultFileUploadState;
	}


	/**
	 * @param type the type to set
	 */
	@Override
	public void setType(WorkflowEvent type) {
		this.type = type;
	}
	
	private class WorkflowStateParser {
		
		private static final int PHASE_INDEX = 0;
		private static final int ROLE_INDEX = 1;
		
		private final WorkflowPhase phase;
		
		private final String roleDescription;
		
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
