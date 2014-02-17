package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class RegisterSeminarViewImpl implements RegisterSeminarView {

	private LayoutPanel main;
	private Button registerButton;

	public RegisterSeminarViewImpl() {

		main = new LayoutPanel();

		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Seminararbeiten");
		main.add(headerPanel);

		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);
		
		// "Professor"Field and Label
		LayoutPanel professorFieldLayout = new LayoutPanel();
		professorFieldLayout.setHorizontal(true);
		Label professorLabel = new Label("Dozent ");
		professorLabel.getElement().getStyle().setMarginRight(10, Unit.PX);
		professorFieldLayout.add(professorLabel);
		MTextBox professorBox = new MTextBox();
		professorBox.setName("professor");
		professorFieldLayout.add(professorBox);
		widgetList.add(professorFieldLayout);
		
		// "Topic"Field and Label
		LayoutPanel topicFieldLayout = new LayoutPanel();
		topicFieldLayout.setHorizontal(true);
		Label topicLabel = new Label("Thema ");
		topicLabel.getElement().getStyle().setMarginRight(10, Unit.PX);
		topicFieldLayout.add(topicLabel);
		MTextBox topicBox = new MTextBox();
		topicBox.setName("topic");
		topicFieldLayout.add(topicBox);
		widgetList.add(topicFieldLayout);
		
		// "term"Field and Label
		LayoutPanel termFieldLayout = new LayoutPanel();
		termFieldLayout.setHorizontal(true);
		Label termLabel = new Label("Semester ");
		termLabel.getElement().getStyle().setMarginRight(10, Unit.PX);
		termFieldLayout.add(termLabel);
		MTextBox termBox = new MTextBox();
		termBox.setName("term");
		termFieldLayout.add(termBox);
		widgetList.add(termFieldLayout);

		
		registerButton= new Button();
		registerButton.setText("Arbeit anmelden");
		widgetList.add(registerButton);
				
		main.add(widgetList);
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

}
