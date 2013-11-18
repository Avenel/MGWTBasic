package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderPinTileButton;
import de.hska.iwi.mgwt.demo.client.widget.ProcessDetailOverview;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
import de.hska.iwi.mgwt.demo.events.PageName;

public class ProcessDetailSeminarViewImpl implements ProcessDetailSeminarView {

	private LayoutPanel main;
	private String title;
	private int activeStep;
	private List<ProcessStep> steps;
	private HeaderPanel headerPanel;
	private Button registerButton;
	private ProcessDetailOverview processDetailOverviewWidget;

	public ProcessDetailSeminarViewImpl(int activeStep, List<ProcessStep> steps) {
		this.activeStep = activeStep;
		this.steps=steps;
		
		main = new LayoutPanel();
		
		headerPanel = new HeaderPanel();
		headerPanel.setCenter(title);
		main.add(headerPanel);

		// add backButton
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		this.processDetailOverviewWidget = new ProcessDetailOverview(this.activeStep, steps.size() - 1);
		ScrollPanel panel = new ScrollPanel();
		panel.add(processDetailOverviewWidget.asWidget());

		registerButton = new Button();
		registerButton.setText("Arbeit anmelden");

		main.add(panel);
	}

	@Override
	public Widget asWidget() {

		headerPanel.setCenter(title);

		return main;
	}

	public void addContentToRootTabPanel(RootTabPanel rtp) {
		rtp.getAnimatableDisplay().setFirstWidget(this.main);
	}

	@Override
	public void render() {

		processDetailOverviewWidget.render(steps);
	}

	@Override
	public Button getRegisterButton() {
		return registerButton;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;

	}

}
