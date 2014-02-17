package de.hska.iwi.mgwt.demo.backend.autobean;

import de.hska.iwi.mgwt.demo.backend.constants.WorkflowEvent;
import de.hska.iwi.mgwt.demo.backend.constants.WorkflowStatusEnum;

public interface IWorkflowStatus {
	
	public WorkflowEvent getType();
	
	public void setType(WorkflowEvent event);
	
	public String getTopic();
	
	public void setTopic(String topic);
	
	public int getAttempt();
	
	public void setAttempt(int attempt);
	
	public String getLecturer();
	
	public void setLecturer(String lecturer);
	
	public String getSecondExaminer();
	
	public void setSecondExaminer(String examinar);
	
	public String getDateOfIssue();
	
	public void setDateOfIssue(String date);
	
	public String getDeadline();
	
	public void setDeadline(String deadline);
	
	public int getOvertime();
	
	public void setOvertime(int overtime);
	
	public String getDateOfHandOver();
	
	public void setDateOfHandOver(String date);
	
	public WorkflowStatusEnum getResultFileUploadState();
	
	public void setResultFileUploadState(WorkflowStatusEnum phase);
	
	public String getWorkFlowState();
	
	public void setWorkFlowState(String workFlowState);
}
