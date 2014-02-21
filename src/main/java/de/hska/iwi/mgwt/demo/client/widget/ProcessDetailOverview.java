package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;

import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessOverviewCell;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

/**
 * A Widget to display the workflow and current status of Process. Its main
 * element is a {@link CellList} with {@link ProcessOverviewCell}s.
 * 
 * @author Simon
 * 
 */
public class ProcessDetailOverview implements IsWidget {

	private CellList<ProcessStep> processes;
	private int activeStep;
	private int maxStepIndex;
	private ProcessOverviewCell cell;

	/**
	 * Constructor to generate and instantiate all elements
	 * @param activeStep the index of the active step of the process to generate that widget for
	 * @param maxStepIndex the index of the last step of the workflow
	 */
	public ProcessDetailOverview(int activeStep, int maxStepIndex) {
		this.activeStep = activeStep;
		this.maxStepIndex = maxStepIndex;
		cell = new ProcessOverviewCell(this.activeStep, this.maxStepIndex);
	}

	@Override
	public Widget asWidget() {
		processes = new CellList<ProcessStep>(cell);

		return processes;
	}
	/**
	 * render the widget with the current ProcessSteps
	 * @param steps the ProcessSteps to render this widget with
	 */
	public void render(List<ProcessStep> steps) {
		cell = new ProcessOverviewCell(this.activeStep, steps.size() - 1);
		processes.render(steps);
		processes.getElement().setClassName("processes-list");
	}

}
