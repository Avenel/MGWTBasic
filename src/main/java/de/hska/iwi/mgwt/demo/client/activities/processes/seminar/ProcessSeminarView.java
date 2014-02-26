package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.CellList;

import de.hska.iwi.mgwt.demo.client.model.Seminar;

/**
 * Interface of the View for the ProcessSeminarActivity. See implementation for
 * specific info
 * 
 * @author Simon
 * 
 */
public interface ProcessSeminarView extends IsWidget {
	/**
	 * Render and update all relevant graphical elements with the given List of
	 * Seminars
	 * 
	 * @param seminarList
	 *            The List of Seminars to be rendered in this view
	 */
	public void render(List<Seminar> seminarList);

	/**
	 * Returns the button to register a new Seminar. This method should be used,
	 * if a listener for button-events is needed
	 * 
	 * @return the Button
	 */
	public Button getRegisterButton();

	/**
	 * Returns the List of Seminars as a CellList. This should be used if a listener for CellList-Events is needed
	 * @return The CellList
	 */
	public CellList<Seminar> getSeminarCellList();

	/**
	 * Sets if the activity is currently loading data
	 * @param loading 
	 */
	void setLoading(boolean loading);

	void displayError();
}
