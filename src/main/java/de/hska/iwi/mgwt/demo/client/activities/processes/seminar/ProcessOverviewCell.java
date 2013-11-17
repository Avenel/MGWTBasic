package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

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
		@SafeHtmlTemplates.Template("<div style='text-align:center; display:block; margin:auto;'><div class='{0}'></div><div class='{1}'><div style='float:left; margin-left:45px;padding-right:500px;'>{2}</div></div><div class='{3}'></div></div>")
		SafeHtml content(String lineStatusBefore, String processStatus, String stepText, String lineStatusAfter);
	}

	public ProcessOverviewCell(int activeStepIndex, int maxStepIndex) {
		this.activeStep = activeStepIndex;
		this.maxStepIndex = maxStepIndex;
	}

	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, ProcessStep step) {
		int currentStepIndex = step.getStepIndex();
		SafeHtml content = null;
		if (currentStepIndex == 0) {
			content = TEMPLATE.content("process-placeholder", "process-done-line",step.getDisplayText(), "line-done");
		} else if (currentStepIndex < activeStep) {
			content = TEMPLATE.content("line-done","process-done-line", step.getDisplayText(), "line-done");
		} else if (currentStepIndex == activeStep && activeStep == maxStepIndex) {
			content = TEMPLATE.content("line-done", "process-active", step.getDisplayText(), "process-placeholder");
		} else if (currentStepIndex == activeStep) {
			content = TEMPLATE.content("line-done","process-active", step.getDisplayText(), "line");
		} else if (currentStepIndex == maxStepIndex) {
			content = TEMPLATE.content("line","process-due-line", step.getDisplayText(), "line");
		}  else if (currentStepIndex > activeStep) {
			content = TEMPLATE.content("line", "process-due-line", step.getDisplayText(), "line");
		}
		safeHtmlBuilder.append(content);

	}

	@Override
	public boolean canBeSelected(ProcessStep model) {
		// TODO Auto-generated method stub
		return false;
	}

}
