package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;
/**
 * Interface for the Model type of a WorkflowInformation. This is necessarry for the GWT AutoBean creation.
 * @author Nico
 *
 */
public interface IWorkflowInformation {
	
	/**
	 * @return the workflow
	 */
	public List<String> getWorkflow();

	/**
	 * @return the applicationHint
	 */
	public String getApplicationHint();

	/**
	 * @return the uploadHint
	 */
	public String getUploadHint();

	/**
	 * @return the noteHint
	 */
	public String getNoteHint();

	/**
	 * @return the applicationDeadlineHint
	 */
	public String getApplicationDeadlineHint();

	/**
	 * @return the uploadDeadlineHint
	 */
	public String getUploadDeadlineHint();

	/**
	 * @return the handOverDeadlineHint
	 */
	public String getHandOverDeadlineHint();

	/**
	 * @param workflow the workflow to set
	 */
	public void setWorkflow(List<String> workflow);

	/**
	 * @param applicationHint the applicationHint to set
	 */
	public void setApplicationHint(String applicationHint);

	/**
	 * @param uploadHint the uploadHint to set
	 */
	public void setUploadHint(String uploadHint);

	/**
	 * @param noteHint the noteHint to set
	 */
	public void setNoteHint(String noteHint);

	/**
	 * @param applicationDeadlineHint the applicationDeadlineHint to set
	 */
	public void setApplicationDeadlineHint(String applicationDeadlineHint);

	/**
	 * @param uploadDeadlineHint the uploadDeadlineHint to set
	 */
	public void setUploadDeadlineHint(String uploadDeadlineHint);

	/**
	 * @param handOverDeadlineHint the handOverDeadlineHint to set
	 */
	public void setHandOverDeadlineHint(String handOverDeadlineHint);

}
