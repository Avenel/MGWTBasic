package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;

/**
 * Widget for a setting item menue link. It is a link to another settings (sub) menu.
 * It consists of a simple label and and arrow icon.
 * @author Martin
 *
 */
public class SettingItemMenuLink implements IsWidget{

	private String fontAwesomeIcon;
	private SettingMenueName targetKey;
	private ClickHandler handler;
	
	/**
	 * Public constructor. Setting up font awesome icon, the target setting menu and its click handler.
	 * @param fontAwesomeIcon
	 * @param targetKey
	 * @param handler
	 */
	public SettingItemMenuLink(String fontAwesomeIcon, SettingMenueName targetKey, ClickHandler handler) {
		this.fontAwesomeIcon = fontAwesomeIcon;
		this.targetKey = targetKey;
		this.handler = handler;
	}
	
	@Override
	public Widget asWidget() {
		FocusPanel linkPanel = new FocusPanel();
		Panel layoutPanel = new HorizontalPanel();
		ParagraphElement pElement = Document.get().createPElement();
		pElement.setInnerHTML("<div style='float:left; width:75%; overflow:hidden; white-space:nowrap; text-overflow: ellipsis;'><i class='fa " + this.fontAwesomeIcon 
								+ " fa-lg' style='margin-right: 15px'></i><b>" + this.targetKey.getHumanReadableName() + "</b></div><div style='float:right; width: 25%; text-align: right'>"
								+ "<i class='fa fa-chevron-right fa-lg'></i></div></div>");
		
		Label menueLabel = new Label();
		menueLabel.getElement().appendChild(pElement);
		linkPanel.add(menueLabel);
		linkPanel.addClickHandler(this.handler);
		
		layoutPanel.setWidth("100%");
		layoutPanel.add(linkPanel);
		return layoutPanel;
	}
	

			
}
