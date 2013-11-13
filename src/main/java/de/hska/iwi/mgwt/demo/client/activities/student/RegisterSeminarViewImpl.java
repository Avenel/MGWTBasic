package de.hska.iwi.mgwt.demo.client.activities.student;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

public class RegisterSeminarViewImpl implements RegisterSeminarView {

	private LayoutPanel main;
	private Button registerButton;

	public RegisterSeminarViewImpl() {

		main = new LayoutPanel();

		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Seminararbeiten");
		main.add(headerPanel);

		HeaderButton backButton = new HeaderButton();
		backButton.setBackButton(true);
		backButton.setText("Back");
		headerPanel.setLeftWidget(backButton);
		
		// handle history back
		backButton.addTapHandler(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				History.back();
			}
		});
		
		WidgetList widgetList = new WidgetList();
		widgetList.setRound(true);
		
		// "Professor"Field and Label
		LayoutPanel professorFieldLayout = new LayoutPanel();
		professorFieldLayout.setHorizontal(true);
		Label professorLabel = new Label("Dozent ");
		professorLabel.setStyleName("labelStyle");
		professorFieldLayout.add(professorLabel);
		MTextBox professorBox = new MTextBox();
		professorBox.setName("professor");
		professorFieldLayout.add(professorBox);
		widgetList.add(professorFieldLayout);
		
		// "Topic"Field and Label
		LayoutPanel topicFieldLayout = new LayoutPanel();
		topicFieldLayout.setHorizontal(true);
		Label topicLabel = new Label("Thema ");
		topicLabel.setStyleName("labelStyle");
		topicFieldLayout.add(topicLabel);
		MTextBox topicBox = new MTextBox();
		topicBox.setName("topic");
		topicFieldLayout.add(topicBox);
		widgetList.add(topicFieldLayout);
		
		// "term"Field and Label
		LayoutPanel termFieldLayout = new LayoutPanel();
		termFieldLayout.setHorizontal(true);
		Label termLabel = new Label("Semester ");
		termLabel.setStyleName("labelStyle");
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

	public void addContentToRootTabPanel(RootTabPanel rtp) {
		rtp.getAnimatableDisplay().setFirstWidget(this.main);
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
