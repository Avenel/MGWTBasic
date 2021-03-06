package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
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

/**
 * Displays a list of all current Seminars. Even if there is only one in a real
 * scenario, this view is able to display a list of seminars for exemplary
 * reasons
 * 
 * @author Simon
 * 
 */
public class ProcessSeminarViewImpl implements ProcessSeminarView {

	private LayoutPanel main;
	private Button registerButton;
	private CellList<Seminar> cellListSeminars;
	private HeaderPinTileButton pinTileButton;
	private HeaderPanel headerPanel;
	private Label loadingLabel;
	private ProgressIndicator loadingProgress;

	/**
	 * Constructor, that sets up all the elements needed in this view alongside
	 * the header.
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
		pinTileButton = new HeaderPinTileButton(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				Tile seminarTile = new Tile("fa-comment-o fa-3x", "Seminare",
						new ProcessSeminarPlace(), true, false);
				TileBoardManager.addTile(seminarTile);
				pinTileButton.setPinned(true);
				Dialogs.alert(
						"Tile angepinnt",
						"Seminar Uebersicht wurde auf deinen Homescreen angepinnt!",
						null);
				headerPanel.setRightWidget(null);
			}
		}, new ProcessSeminarPlace());
		headerPanel.setRightWidget(pinTileButton.asWidget());

		this.cellListSeminars = new CellList<Seminar>(new SeminarCell("blubb"));
		ScrollPanel panelIM = new ScrollPanel();
		panelIM.add(cellListSeminars);

		loadingProgress = new ProgressIndicator();
		loadingProgress.setVisible(true);
		loadingProgress.setSize("50px", "50px");
		loadingProgress.getElement().getStyle()
				.setProperty("marginLeft", "auto");
		loadingProgress.getElement().getStyle()
				.setProperty("marginRight", "auto");
		loadingProgress.getElement().getStyle().setMarginTop(10, Unit.PX);
		loadingProgress.setTitle("getting Data from the server");

		loadingLabel = new Label();
		loadingLabel.setText("Lade neueste Daten...");
		loadingLabel.getElement().getStyle().setColor("grey");
		loadingLabel.getElement().getStyle().setMarginTop(5, Unit.PX);
		loadingLabel.getElement().getStyle().setTextAlign(TextAlign.CENTER);

		registerButton = new Button();
		registerButton.setText("Arbeit anmelden");

		main.add(registerButton);
		main.add(cellListSeminars);
		main.add(loadingProgress);
		main.add(loadingLabel);
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
	public CellList<Seminar> getSeminarCellList() {
		return this.cellListSeminars;
	}

	@Override
	public void setLoading(boolean loading) {
		loadingProgress.setVisible(loading);
		loadingLabel.setText("Lade neueste Daten...");
		loadingLabel.setVisible(loading);
	}
	@Override
	public void displayError(){
		loadingProgress.setVisible(false);
		loadingLabel.setText("Der Server ist nicht erreichbar. Versuche es später erneut!");
		loadingLabel.setVisible(true);
	}

}
