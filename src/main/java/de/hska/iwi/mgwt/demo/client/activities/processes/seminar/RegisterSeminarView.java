package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.Map;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.Button;

/**
 * View-Interface for RegisterSeminarActivity
 * 
 * @author Simon
 * 
 */
public interface RegisterSeminarView extends IsWidget {

	/**
	 * Enum of available inputFields
	 * 
	 * @author Simon
	 * 
	 */
	public enum InputField {
		ProfessorField, TermField, TopicField
	}

	/**
	 * Renders and updates all relevant graphical elements
	 */
	public void render();

	/**
	 * Gets the button, that has to be activated to register a seminar. This
	 * should be used, if listeners for button-events are needed
	 * 
	 * @return the Button
	 */
	public Button getRegisterButton();

	/**
	 * Gets a Map of values, that were entered into the graphical-view-elements
	 * 
	 * @return
	 */
	public Map<InputField, String> getInputs();
}
