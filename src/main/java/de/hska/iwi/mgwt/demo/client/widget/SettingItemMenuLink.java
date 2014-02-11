package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;

public class SettingItemMenuLink implements IsWidget{

	private String fontAwesomeIcon;
	private SettingMenueName targetKey;
	private ClickHandler handler;
	
	public SettingItemMenuLink(String fontAwesomeIcon, SettingMenueName targetKey, ClickHandler handler) {
		this.fontAwesomeIcon = fontAwesomeIcon;
		this.targetKey = targetKey;
		this.handler = handler;
	}
	
	
	public Widget asWidget() {
		ParagraphElement pElement = Document.get().createPElement();
		pElement.setInnerHTML("<div style='float:left'><i class='fa " + this.fontAwesomeIcon 
								+ " fa-lg' style='margin-right: 15px'></i><b>" + this.targetKey.getHumanReadableName() + "</b></div><div style='float:right'>"
								+ "<i class='fa fa-chevron-right fa-lg'></i></div>");
		
		Label menueLabel = new Label();
		menueLabel.getElement().appendChild(pElement);
		
		menueLabel.addClickHandler(this.handler);
		return menueLabel;
	}
	

			
}
