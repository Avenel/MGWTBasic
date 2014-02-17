package de.hska.iwi.mgwt.demo.client.activities.processes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

public class ProcessOverviewCell implements Cell<ProcessStep> {

	int activeStep;
	int maxStepIndex;

	private static Template TEMPLATE = GWT.create(Template.class);

	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div style='text-align:center; display:block; margin:auto;'><div class='{0}'></div><div><div style='float:left' class='{1}'></div><div class='{2}'>{3}</div></div><div class='{4}'></div></div>")
		SafeHtml content(String lineBeforeClass, String processClass,String textClass, String stepTextString, String lineAfterClass);
	}

	public ProcessOverviewCell(int activeStepIndex, int maxStepIndex) {
		this.activeStep = activeStepIndex;
		this.maxStepIndex = maxStepIndex;
	}

	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, ProcessStep step) {
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
