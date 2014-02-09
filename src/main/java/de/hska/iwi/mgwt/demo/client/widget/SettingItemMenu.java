package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SettingItemMenu implements IsWidget{

	private String title;
	private String fontAwesomeIcon;
	
	public SettingItemMenu(String title, String fontAwesomeIcon) {
		this.title = title;
		this.fontAwesomeIcon = fontAwesomeIcon;
	}
	
	
	public Widget asWidget() {
		ParagraphElement pElement = Document.get().createPElement();
		pElement.setInnerHTML("<i class='fa "+ this.fontAwesomeIcon + " fa-lg'></i> " + this.title);
		
		Label menueLabel = new Label();
		menueLabel.getElement().getStyle().setBackgroundColor("#ED8689");
		menueLabel.getElement().appendChild(pElement);
		return menueLabel;
	}
	

			
}
