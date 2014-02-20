package de.hska.iwi.mgwt.demo.backend.autobean;

import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowStatusEnum;
/**
 * Interface type for the model class of a WorkflowStatus. This Interface is necessary for the GWT AutoBean creation.
 * @author Nico
 *
 */
public interface IWorkflowStatus {
	/**
	 * @return the type
	 */
	public WorkflowEvent getType();
	/**
	 * @param type the type to set
	 */
	public void setType(WorkflowEvent event);
	/**
	 * @return the topic
	 */
	public String getTopic();
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic);
	/**
	 * @return the attempt
	 */
	public int getAttempt();
	/**
	 * @param attempt the attempt to set
	 */
	public void setAttempt(int attempt);
	/**
	 * @return the lecturer
	 */
	public String getLecturer();
	/**
	 * @param lecturer the lecturer to set
	 */
	public void setLecturer(String lecturer);
	/**
	 * @return the secondExaminer
	 */
	public String getSecondExaminer();
	/**
	 * @param secondExaminer the secondExaminer to set
	 */
	public void setSecondExaminer(String examinar);
	/**
	 * @return the dateOfIssue
	 */
	public String getDateOfIssue();
	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	public void setDateOfIssue(String date);
	/**
	 * @return the deadline
	 */
	public String getDeadline();
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(String deadline);
	/**
	 * @return the overtime
	 */
	public int getOvertime();
	/**
	 * @param overtime the overtime to set
	 */
	public void setOvertime(int overtime);
	/**
	 * @return the dateOfHandOver
	 */
	public String getDateOfHandOver();
	/**
	 * @param dateOfHandOver the dateOfHandOver to set
	 */
	public void setDateOfHandOver(String date);
	/**
	 * @return the resultFileUploadState
	 */
	public WorkflowStatusEnum getResultFileUploadState();
	/**
	 * @param resultFileUploadState the resultFileUploadState to set
	 */
	public void setResultFileUploadState(WorkflowStatusEnum phase);
	/**
	 * @return the workFlowState
	 */
	public String getWorkFlowState();
	/**
	 * @param workFlowState the workFlowState to set
	 */
	public void setWorkFlowState(String workFlowState);
}
