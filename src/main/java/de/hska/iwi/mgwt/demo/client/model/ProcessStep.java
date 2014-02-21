package de.hska.iwi.mgwt.demo.client.model;

/**
 * Representation of a certain Step, a Process can take.
 * 
 * @author Simon
 * 
 */
public class ProcessStep {

	/**
	 * The displaytext. This should be used to represent the Step (usually shown
	 * to the user) and therefore should be something short, useful and concise
	 * to the user
	 */
	private String displayText;
	/**
	 * The index of this step inside the Process-workflow. Start with 0.
	 */
	private int stepIndex;

	/**
	 * Constructor
	 * 
	 * @param displayText
	 *            This should be used to represent the Step (usually shown to
	 *            the user) and therefore should be something short, useful and
	 *            concise to the user
	 * @param stepIndex
	 *            The index of this step inside the Process-workflow. Start with
	 *            0. This has to be mapped to e.g. {@link Seminar#getStatus()}
	 *            or any other process representing model
	 */
	public ProcessStep(String displayText, int stepIndex) {
		this.displayText = displayText;
		this.stepIndex = stepIndex;
	}

	/**
	 * Gets the displayText of the ProcessStep
	 * 
	 * @return the Text to display (e.g. in an overview)
	 */
	public String getDisplayText() {
		return displayText;
	}

	/**
	 * Gets the StepIndex of the ProcessStep
	 * 
	 * @return The index. Starting with 0
	 */
	public int getStepIndex() {
		return stepIndex;
	}

}
