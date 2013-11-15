package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

/**
 * Represents a tile. It has a front- and backside.
 * On the front it has an icon and a title + information.
 * On the back it has more detailed information.
 * It flips after some time...
 * 
 * @author Martin
 *
 */
public class Tile implements IsWidget {
	
	LayoutPanel frontPanel;
	String iconURL;
	String title;
	String color;
	
	
	/**
	 * Public constructor.
	 * @param frontPanel
	 * @param iconURL
	 * @param title
	 * @param color
	 */
	public Tile(String iconURL, String title) {
		super();
		this.iconURL = iconURL;
		this.title = title;
		
		// official HS Karlsruhe color
		this.color = "#DB0134";
	}


	@Override
	public Widget asWidget() {
		this.frontPanel = new LayoutPanel();
		
		// set size
		this.frontPanel.setWidth("80px");
		this.frontPanel.setHeight("80px");

		// set background color
		this.frontPanel.getElement().getStyle().setBackgroundColor(this.color);
		this.frontPanel.getElement().getStyle().setMargin(10, Unit.PX);
		
		// setup border & border radius
		this.frontPanel.getElement().getStyle().setBorderWidth(2, Unit.PX);
		this.frontPanel.getElement().getStyle().setBorderStyle(BorderStyle.NONE);
		this.frontPanel.getElement().getStyle().setProperty("borderRadius", "15px");
		
		// add icon
		Image icon = new Image(this.iconURL);
		icon.setWidth("50px");
		
		icon.getElement().getStyle().setMarginLeft(15, Unit.PX);
		icon.getElement().getStyle().setMarginRight(15, Unit.PX);
		icon.getElement().getStyle().setMarginTop(5, Unit.PX);
		this.frontPanel.add(icon);
		
		// adding title
		Label titleBox = new Label();
		titleBox.setText(this.title);
		titleBox.setWidth("70x");
		
		// font style
		titleBox.getElement().getStyle().setFontSize(12, Unit.PX);
		titleBox.getElement().getStyle().setProperty("fontFamily", "Helvetica, consolas");
		titleBox.getElement().getStyle().setColor("#FFFFFF");
		
		// setup margin
		titleBox.getElement().getStyle().setMarginLeft(5, Unit.PX);
		titleBox.getElement().getStyle().setMarginRight(5, Unit.PX);
		titleBox.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		
		
		this.frontPanel.add(titleBox);
		
		return this.frontPanel;
	}
	
	/**
	 * Setup tap handler for user interactions.
	 * @param handler
	 */
	public void addTapHandler(TapHandler handler) {
		this.frontPanel.addHandler(handler, TapEvent.getType());
	}

}
