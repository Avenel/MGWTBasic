package de.hska.iwi.mgwt.demo.client.activities.processes;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

/**
 * Interface for the ProcessDetailView. This is used to represent the full
 * workflow of a Process and the current step it is in.
 * 
 * @author Simon
 * 
 */
public interface ProcessDetailView extends IsWidget {

	/**
	 * Sets the title to display in the header bar.
	 * @param title the text to display
	 */
	public void setTitle(String title);

	/**
	 * renders the current view and refreshes all relevant elements
	 */
	public void render();
	
	/**
	 * renders the current view and refreshes all relevant elements.
	 * Use this method, if the steps for this Process have changed.
	 * @param steps a list of steps, the current workflow has.
	 */
	public void render(List<ProcessStep> steps);
}
