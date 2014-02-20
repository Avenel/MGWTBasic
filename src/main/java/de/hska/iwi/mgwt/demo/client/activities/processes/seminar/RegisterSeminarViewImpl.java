package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import java.util.ArrayList;
import java.util.List;

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
import de.hska.iwi.mgwt.demo.client.widget.AccordionInputWidget;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class RegisterSeminarViewImpl implements RegisterSeminarView {

	private ScrollPanel panel;
	private LayoutPanel main;
	private Button registerButton;
	private AccordionInputWidget professorAccordion;
	private AccordionInputWidget termAccordion;
	private MTextBox topicBox;

	public RegisterSeminarViewImpl() {

		panel = new ScrollPanel();
		main = new LayoutPanel();
		LayoutPanel wrapper = new LayoutPanel();

		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Seminararbeiten");
		wrapper.add(headerPanel);

		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);
		
		// "Professor"Field and Label
		professorAccordion= new AccordionInputWidget("Dozent: ", null, SeminarTempStorage.getLecturers(), false, panel);
		widgetList.add(professorAccordion.asWidget());
		
		// "Topic"Field and Label
		LayoutPanel topicFieldLayout = new LayoutPanel();
		topicFieldLayout.setHorizontal(true);
		Label topicLabel = new Label("Thema ");
		topicLabel.getElement().getStyle().setMarginRight(10, Unit.PX);
		topicFieldLayout.add(topicLabel);
		topicBox = new MTextBox();
		topicBox.setName("topic");
		topicFieldLayout.add(topicBox);
		widgetList.add(topicFieldLayout);
		
		// "term"Field and Label
		termAccordion= new AccordionInputWidget("Semester: ", null, new String[]{"WS13/14","SS14"}, false, panel);
		termAccordion.asWidget().getElement().getStyle().setProperty("horizontalAlign", "left");
		widgetList.add(termAccordion.asWidget());
		
		registerButton= new Button();
		registerButton.setText("Arbeit anmelden");
		registerButton.getElement().getStyle().setProperty("horizontalAlign", "center");
		
				
		wrapper.add(widgetList);
		wrapper.add(registerButton);
		panel.add(wrapper);
		main.add(panel);
	}

	@Override
	public Widget asWidget() {
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
	
	public List<String> getInputs(){
		List<String> retList= new ArrayList<String>();
		retList.add(professorAccordion.getValue());
		retList.add(topicBox.getValue());
		retList.add(termAccordion.getValue());
		
		return retList;
	}

}
