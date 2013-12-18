package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;

import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessOverviewCell;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

public class ProcessDetailOverview implements IsWidget {
	
	CellList<ProcessStep> processes;
	int activeStep;
	int maxStepIndex;
	
	public ProcessDetailOverview(int activeStep, int maxStepIndex){
		this.activeStep=activeStep;
		this.maxStepIndex=maxStepIndex;
	}

	@Override
	public Widget asWidget() {
		processes= new CellList<ProcessStep>(new ProcessOverviewCell(this.activeStep, this.maxStepIndex));
		
		
		return processes;
	}
	public void render(List<ProcessStep> steps){
		processes.render(steps);
		processes.getElement().setClassName("processes-list");
	}
	
	

}
