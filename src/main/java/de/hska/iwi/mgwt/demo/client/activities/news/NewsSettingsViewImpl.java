package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.widget.CheckBoxWidget;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

public class NewsSettingsViewImpl implements NewsSettingsView {

	private LayoutPanel main;
	private String title;
	
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
	    widgetList.add(new CheckBoxWidget("IWI").asWidget());
	    
	    // IB
	    widgetList.add(new CheckBoxWidget("IB").asWidget());
	    
	    // IM
	    widgetList.add(new CheckBoxWidget("IM").asWidget());
	    
	    // MKI
	    widgetList.add(new CheckBoxWidget("MKI").asWidget());
	    
	    this.main.add(widgetList);
	}
	
	
	@Override
	public Widget asWidget() {	
		return this.main;
	}

}
