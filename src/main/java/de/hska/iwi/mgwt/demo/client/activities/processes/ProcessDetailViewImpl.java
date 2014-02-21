package de.hska.iwi.mgwt.demo.client.activities.processes;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.model.ProcessStep;
import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderPinTileButton;
import de.hska.iwi.mgwt.demo.client.widget.ProcessDetailOverview;
import de.hska.iwi.mgwt.demo.client.widget.Tile;

/**
 * Implements a graphical overview for a process. It displays all ProcessSteps
 * for a given process (eg. representing a {@link Seminar}) and the current
 * status the Workflow has. It purely uses CSS to do so. The HTML and CSS
 * implementation can be reviewed in {@link ProcessOverviewCell}.
 * 
 * @author Simon
 * 
 */
public class ProcessDetailViewImpl implements ProcessDetailView {

	private LayoutPanel main;
	private String title;
	private int activeStep;
	private List<ProcessStep> steps;
	private HeaderPanel headerPanel;
	private ProcessDetailOverview processDetailOverviewWidget;
	private HeaderPinTileButton pinTileButton;

	/**
	 * Constructor
	 * @param activeStep the current active index of the Process/workflow
	 * @param steps the steps this Process/workflow can pass through.
	 * @param id the id of the Process/workflow to represent graphically
	 */
	public ProcessDetailViewImpl(int activeStep, List<ProcessStep> steps,
			final int id) {
		this.activeStep = activeStep;
		this.steps = steps;

		main = new LayoutPanel();

		headerPanel = new HeaderPanel();
		headerPanel.setCenter(title);
		main.add(headerPanel);

		// add backButton
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());

		// PinTile to Home Button
		pinTileButton = new HeaderPinTileButton(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				Tile processTile = new Tile("fa-ellipsis-v fa-3x", "Detail",
						new ProcessDetailPlace(String.valueOf(id)), true, false);
				TileBoardManager.addTile(processTile);
				pinTileButton.setPinned(true);
				Dialogs.alert(
						"Tile angepinnt",
						"Dieser Prozess wurde auf Deinen Homescreen angepinnt!",
						null);
				headerPanel.setRightWidget(null);
			}
		}, new ProcessDetailPlace(String.valueOf(id)));
		headerPanel.setRightWidget(pinTileButton.asWidget());

		this.processDetailOverviewWidget = new ProcessDetailOverview(
				this.activeStep, steps.size() - 1);
		ScrollPanel panel = new ScrollPanel();
		panel.add(processDetailOverviewWidget.asWidget());

		main.add(panel);
	}

	@Override
	public Widget asWidget() {
		if (!this.pinTileButton.isPinned()) {
			this.headerPanel.setRightWidget(pinTileButton.asWidget());
		} else {
			this.headerPanel.setRightWidget(null);
		}

		headerPanel.setCenter(title);
		return main;
	}

	@Override
	public void render() {
		processDetailOverviewWidget.render(this.steps);
	}

	@Override
	public void render(List<ProcessStep> steps) {
		processDetailOverviewWidget.render(steps);
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

}
