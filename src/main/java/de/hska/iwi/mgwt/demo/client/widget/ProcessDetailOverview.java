package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;

import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessOverviewCell;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

public class ProcessDetailOverview implements IsWidget {
	
	CellList<ProcessStep> processes;
	int activeStep;
	int maxStepIndex;
	ProcessOverviewCell cell;
	
	public ProcessDetailOverview(int activeStep, int maxStepIndex){
		this.activeStep=activeStep;
		this.maxStepIndex=maxStepIndex;
		cell= new ProcessOverviewCell(this.activeStep, this.maxStepIndex);
	}

	@Override
	public Widget asWidget() {
		processes= new CellList<ProcessStep>(cell);
		
		
		return processes;
	}
	public void render(List<ProcessStep> steps){
		cell=new ProcessOverviewCell(this.activeStep, steps.size()-1);
		processes.render(steps);
		processes.getElement().setClassName("processes-list");
	}
	
	
	
	

}
