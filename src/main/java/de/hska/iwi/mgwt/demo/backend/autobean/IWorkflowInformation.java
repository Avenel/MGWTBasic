package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface IWorkflowInformation {
	
	public List<String> getWorkflow();
	
	public void setWorkflow(List<String> workflow);
	
	public String getApplicationHint();
	
	public void setApplicationHint(String applicationHint);
	
	public String getUploadHint();
	
	public void setUploadHint(String uploadHint);
	
	public String getNoteHint();
	
	public void setNoteHint(String noteHint);
	
	public String getApplicationDeadlineHint();
	
	public void setApplicationDeadlineHint(String applicationDeadlineHint);
	
	public String getUploadDeadlineHint();
	
	public void setUploadDeadlineHint(String uploadDeadlineHint);
	
	public String getHandOverDeadlineHint();
	
	public void setHandOverDeadlineHint(String handOverDeadlineHint);

}
