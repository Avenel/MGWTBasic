package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class CustomHeaderButton extends HeaderButton {
	
	private ParagraphElement pElement;
	
	
	@Override
	public void setText(String text) {
		// remove old PElement and create new one
		this.getElement().removeChild(getElement().getLastChild());
		this.pElement = Document.get().createPElement();
		pElement.addClassName(this.headerCss.headerButtonText());
		
		pElement.setInnerHTML(text);
		
		getElement().appendChild(pElement);
	}

}
