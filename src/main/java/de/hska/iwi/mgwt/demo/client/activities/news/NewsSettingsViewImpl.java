package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.widget.CheckBoxWidget;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class NewsSettingsViewImpl implements NewsSettingsView {

	private LayoutPanel main;
	private String title;
	private CheckBoxWidget iwiCheckBox;
	private CheckBoxWidget ibCheckBox;
	private CheckBoxWidget imCheckBox;
	private CheckBoxWidget mkiCheckBox;
	
	public NewsSettingsViewImpl() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		this.title = "Aktuelles - Einstellungen";		
		headerPanel.setCenter(this.title);
		this.main.add(headerPanel);
		
		// back button
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		// Checkboxes for different filters
		WidgetList widgetList = new WidgetList();
	    widgetList.setRound(true);
	    
		// IWI
	    iwiCheckBox = new CheckBoxWidget("IWI");
	    widgetList.add(iwiCheckBox.asWidget());
	    
	    // IB
	    ibCheckBox = new CheckBoxWidget("IB");
	    widgetList.add(ibCheckBox.asWidget());
	    
	    // IM
	    imCheckBox = new CheckBoxWidget("IM");
	    widgetList.add(imCheckBox.asWidget());
	    
	    // MKI
	    mkiCheckBox = new CheckBoxWidget("MKI");
	    widgetList.add(mkiCheckBox.asWidget());
	    
	    this.main.add(widgetList);
	}
	
	
	@Override
	public Widget asWidget() {	
		return this.main;
	}


	@Override
	public CheckBoxWidget getIWIFilterCheckBox() {
		return this.iwiCheckBox;
	}


	@Override
	public CheckBoxWidget getIMFilterCheckBox() {
		return this.imCheckBox;
	}


	@Override
	public CheckBoxWidget getIBFilterCheckBox() {
		return this.ibCheckBox;
	}


	@Override
	public CheckBoxWidget getMKIFilterCheckBox() {
		return mkiCheckBox;
	}

}
