package de.hska.iwi.mgwt.demo.client.activities.processes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;


/**
 * Implements a cell to represent a step of a Process. It purely uses HTML and
 * CSS to do so. It basically consists of 4+1 parts: 1. a line to the state (due
 * and done) 2. the state itself(active/not active but due/ not active and done)
 * 3. a text to describe the current step (+the CSS class for this text) 4. a
 * line from the current step to the next
 * 
 * @author Simon
 * 
 */
public class ProcessOverviewCell implements Cell<ProcessStep> {
	
	private int activeStep;
	private int maxStepIndex;

	private static Template TEMPLATE = GWT.create(Template.class);

	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div style='text-align:center; display:block; margin:auto;'><div class='{0}'></div><div><div style='float:left' class='{1}'></div><div class='{2}'>{3}</div></div><div class='{4}'></div></div>")
		SafeHtml content(String lineBeforeClass, String processClass,
				String textClass, String stepTextString, String lineAfterClass); //*Class stands for a css class in main.css
	}

	/**
	 * Constructor
	 * 
	 * @param activeStepIndex
	 *            The active step of the corresponding Process/Overview
	 * @param maxStepIndex
	 *            The max index of the steps to render
	 */
	public ProcessOverviewCell(int activeStepIndex, int maxStepIndex) {
		this.activeStep = activeStepIndex;
		this.maxStepIndex = maxStepIndex;
	}

	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, ProcessStep step) {
		//since this method is called for every element in a cellList, this method is called in a loop ( once for every cell/ProcessStep)
		int currentStepIndex = step.getStepIndex();
		SafeHtml content = null;
		// Process's status has index 0
		if(currentStepIndex==activeStep&&activeStep==0){
			content = TEMPLATE.content("process-placeholder", "process-active", "text-done",step.getDisplayText(), "line");
		}else if (currentStepIndex == 0) { //we generate the first cell, active step has a higher index than 0
			content = TEMPLATE.content("process-placeholder", "process-done-line","text-done",step.getDisplayText(), "line-done");
		} else if (currentStepIndex < activeStep) { //we generate a cell, that is "before" the active step of the process's status
			content = TEMPLATE.content("line-done","process-done-line","text-done", step.getDisplayText(), "line-done");
		} else if (currentStepIndex == activeStep && activeStep == maxStepIndex) {// the current process's step is the last one and we generate that one
			content = TEMPLATE.content("line-done", "process-active","text-done", step.getDisplayText(), "process-placeholder");
		} else if (currentStepIndex == activeStep) { // the process's state is somewhere in the middle of the workflow
			content = TEMPLATE.content("line-done","process-active","text-done", step.getDisplayText(), "line");
		} else if (currentStepIndex == maxStepIndex) { // the cell we generate is after the current active step of the process and is the last to render
			content = TEMPLATE.content("line","process-due-line","text-due", step.getDisplayText(), "line");
		}  else if (currentStepIndex > activeStep) { //the cell we generate is after the current active step of the process
			content = TEMPLATE.content("line", "process-due-line", "text-due",step.getDisplayText(), "line");
		}
		safeHtmlBuilder.append(content);

	}

	@Override
	public boolean canBeSelected(ProcessStep model) {
		return false;
	}

}
