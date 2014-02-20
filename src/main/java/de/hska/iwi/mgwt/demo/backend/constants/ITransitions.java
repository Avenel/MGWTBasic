package de.hska.iwi.mgwt.demo.backend.constants;

/**
 * This interface specifies methods which are used to parse something. It is more or less like an Automaton.
 * @author Nico
 *
 */
public interface ITransitions {
	/**
	 * Determines the final state (like creating a description of a state) by the given input String.
	 * @param status the current input String which the current element has to handle.
	 */
	public void parseStatus(String status);

}
