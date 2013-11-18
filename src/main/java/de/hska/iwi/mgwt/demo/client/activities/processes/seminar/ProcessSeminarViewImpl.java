package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderPinTileButton;
import de.hska.iwi.mgwt.demo.client.widget.Tile;
import de.hska.iwi.mgwt.demo.events.PageName;

public class ProcessSeminarViewImpl implements ProcessSeminarView {

	private LayoutPanel main;
	private Button registerButton;
	private CellList<Seminar> cellListSeminars;
	private HeaderPinTileButton pinTileButton;
	
	public ProcessSeminarViewImpl() {

		main = new LayoutPanel();

		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Seminararbeiten");
		main.add(headerPanel);
	
		
		// Back Button
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
	
		// PinTile to Home Button
		pinTileButton = new HeaderPinTileButton(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				Tile seminarTile = new Tile("assets/icons/Process.png", "Seminare", new ProcessSeminarPlace());
				TileBoardManager.addTile(seminarTile);
				pinTileButton.setPinned(true);
			}
		});
		headerPanel.setRightWidget(pinTileButton.asWidget());
		
		this.cellListSeminars = new CellList<Seminar>(new SeminarCell("blubb"));
		ScrollPanel panelIM = new ScrollPanel();
		panelIM.add(cellListSeminars);

		
		registerButton= new Button();
		registerButton.setText("Arbeit anmelden");
		
		main.add(registerButton);
		main.add(cellListSeminars);
	}

	@Override
	public Widget asWidget() {
		if (this.pinTileButton.isPinned()) {
			this.pinTileButton.asWidget().getElement().getStyle().setDisplay(Display.NONE);
		} else {
			this.pinTileButton.asWidget().getElement().getStyle().setDisplay(Display.BLOCK);
		}
		
		return main;
	}

	public void addContentToRootTabPanel(RootTabPanel rtp) {
		rtp.getAnimatableDisplay().setFirstWidget(this.main);
	}

	@Override
	public void render(List<Seminar> seminarList) {
		
		cellListSeminars.render(seminarList);
	}

	@Override
	public Button getRegisterButton() {
		return registerButton;
	}
	
	@Override
	public CellList<Seminar> getSeminarCellList(){
		return this.cellListSeminars;
	}

}
