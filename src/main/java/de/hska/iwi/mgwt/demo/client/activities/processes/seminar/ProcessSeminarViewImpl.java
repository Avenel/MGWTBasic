package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ProgressIndicator;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.client.model.Seminar;
import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderPinTileButton;
import de.hska.iwi.mgwt.demo.client.widget.Tile;

public class ProcessSeminarViewImpl implements ProcessSeminarView {

	private LayoutPanel main;
	private Button registerButton;
	private CellList<Seminar> cellListSeminars;
	private HeaderPinTileButton pinTileButton;
	private HeaderPanel headerPanel;
	private VerticalPanel loadingPanel;
	
	/**
	 * Public constructor.
	 */
	public ProcessSeminarViewImpl() {

		main = new LayoutPanel();

		headerPanel = new HeaderPanel();
		headerPanel.setCenter("Seminararbeiten");
		main.add(headerPanel);
	
		
		// Back Button
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
	
		// PinTile to Home Button
		pinTileButton = new HeaderPinTileButton(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				Tile seminarTile = new Tile("fa-comment-o fa-3x", "Seminare", new ProcessSeminarPlace(), true, false);
				TileBoardManager.addTile(seminarTile);
				pinTileButton.setPinned(true);
				Dialogs.alert("Tile angepinnt", "Seminar Uebersicht wurde auf deinen Homescreen angepinnt!", null);
				headerPanel.setRightWidget(null);
			}
		}, new ProcessSeminarPlace());
		headerPanel.setRightWidget(pinTileButton.asWidget());
		
		this.cellListSeminars = new CellList<Seminar>(new SeminarCell("blubb"));
		ScrollPanel panelIM = new ScrollPanel();
		panelIM.add(cellListSeminars);
		
		loadingPanel = new VerticalPanel();
		ProgressIndicator loadingProgress;
		loadingProgress = new ProgressIndicator();
		loadingProgress.setVisible(true);
		loadingProgress.setSize("50px", "50px");
		loadingProgress.getElement().getStyle().setMarginLeft(37, Unit.PCT);
		//loadingProgress.getElement().getStyle().setMarginLeft(50, Unit.PCT);
		loadingProgress.setTitle("getting Data from the server");
		
		Label test= new Label();
		test.setText("Lade neueste Daten vom Server...");
		test.getElement().getStyle().setColor("grey");
		test.getElement().getStyle().setMarginTop(5, Unit.PCT);
		test.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		loadingPanel.add(loadingProgress);
		loadingPanel.add(test);
		loadingPanel.getElement().getStyle().setProperty("margin"," 0 auto");
		loadingPanel.getElement().getStyle().setProperty("marginTop"," 10px");

		
		registerButton= new Button();
		registerButton.setText("Arbeit anmelden");
		
		main.add(registerButton);
		main.add(cellListSeminars);
		main.add(loadingPanel);
	}

	@Override
	public Widget asWidget() {
		if (!this.pinTileButton.isPinned()) {
			this.headerPanel.setRightWidget(pinTileButton.asWidget());
		} else {
			this.headerPanel.setRightWidget(null);
		}
		
		return main;
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
	
	@Override
	public void setLoading(boolean loading){
		loadingPanel.setVisible(loading);
	}

}
