package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.model.SeminarTempStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;
import de.hska.iwi.mgwt.demo.client.widget.AccordionInputWidget;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.TextInputWidget;

/**
 * View to register a new Seminar. This view displays a form for the user to
 * fill out and a button to send the data to the client. It uses
 * {@link AccordionInputWidget} for the professor and term field, and a simple
 * TextBox for the topic field.
 * 
 * @author Simon
 * 
 */
public class RegisterSeminarViewImpl implements RegisterSeminarView {

	private Button registerButton;
	private AccordionInputWidget professorAccordion;
	private AccordionInputWidget termAccordion;
	private MTextBox topicBox;
	private LayoutPanel main;
	private ScrollPanel formScrollPanel;
	private LayoutPanel formLayoutPanel;

	/**
	 * Constructor that builds all necessary elements
	 */
	public RegisterSeminarViewImpl() {
	}

	@Override
	public Widget asWidget() {
this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Seminararbeiten");
		main.add(headerPanel);

		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		this.formScrollPanel = new ScrollPanel();
		this.formLayoutPanel = new LayoutPanel();
	
		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);

		// "Professor"Field and Label
		professorAccordion = new AccordionInputWidget("Dozent: ", null,
				SeminarTempStorage.getLecturers(), false, this.formScrollPanel);
		widgetList.add(professorAccordion.asWidget());

		// "Topic"Field and Label
		LayoutPanel topicFieldLayout = new LayoutPanel();
		topicFieldLayout.setHorizontal(true);
		Label topicLabel = new Label("Thema ");
		
		topicLabel.getElement().getStyle().setProperty("overflow", "hidden");
		topicLabel.getElement().getStyle().setProperty("whiteSpace", "nowrap");
		topicLabel.getElement().getStyle().setProperty("textOverflow", "ellipsis");
		topicLabel.getElement().getStyle().setWidth(35, Unit.PCT);
		topicFieldLayout.add(topicLabel);
		
		topicBox = new MTextBox();
		topicBox.setName("topic");
		topicFieldLayout.add(topicBox);
		widgetList.add(topicFieldLayout);
		
		// "term"Field and Label
		termAccordion = new AccordionInputWidget("Semester: ", null,
				new String[] { "WS13/14", "SS14" }, false, this.formScrollPanel);
		termAccordion.asWidget().getElement().getStyle()
				.setProperty("horizontalAlign", "left");
		widgetList.add(termAccordion.asWidget());
		
		this.formLayoutPanel.add(widgetList);
		
		registerButton = new Button();
		registerButton.setText("Arbeit anmelden");
		registerButton.getElement().getStyle()
				.setProperty("horizontalAlign", "center");
		this.formLayoutPanel.add(registerButton);
		
		this.formScrollPanel.add(this.formLayoutPanel);
		this.main.add(this.formScrollPanel);
		
		return main;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public Button getRegisterButton() {
		return registerButton;
	}

	@Override
	public Map<InputField, String> getInputs() {
		Map<InputField, String> retMap = new HashMap<InputField, String>();
		retMap.put(InputField.ProfessorField,
				professorAccordion.getValue());
		retMap.put(InputField.TopicField, topicBox.getValue());
		retMap.put(InputField.TermField, termAccordion.getValue());

		return retMap;
	}

}
