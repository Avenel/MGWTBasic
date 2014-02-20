package de.hska.iwi.mgwt.demo.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class AccordionInputWidget implements IsWidget, InputWidget {

	Label text;
	LayoutPanel valuePanel;
	Label currentValueText;
	
	WidgetList valuePanelsWrapper;
	List<FocusPanel> valuePanels;
	
	ScrollPanel parentScrollPanel;
	
	StorageKey key;
	ClickHandler handler;
	FocusPanel focusValuePanel;
	Label arrowDown;
	String value;
	
	String[] possibleValues;
	
	/**
	 * Public constructor. Setting up widget.
	 * @param text
	 * @param key
	 * @param values
	 */
	public AccordionInputWidget (String text, final StorageKey key, String[] values, final boolean saveInLocalStorage, ScrollPanel parent) {
		this.text = new Label(text);		
		
		this.key = key;
		this.parentScrollPanel = parent;
		
		// setting up valuePanel (displays current Value)
		this.valuePanel = new LayoutPanel();
		this.currentValueText = new Label();
		this.currentValueText.setText(values[0]);
		this.valuePanel.add(currentValueText);
		
		this.handler = new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (valuePanelsWrapper.isVisible()) {
					valuePanelsWrapper.setVisible(false);
					// store value
					String val = currentValueText.getText();
					if(saveInLocalStorage){
						SettingStorage.storeValue(key, val, false);
					}
					value=val;
					
					arrowDown.getElement().removeClassName("arrowUp");
					arrowDown.getElement().removeClassName("arrowRotateDown");
					arrowDown.getElement().addClassName("arrowRotateUp");
					
					parentScrollPanel.refresh();
				} else {
					valuePanelsWrapper.setVisible(true);
					arrowDown.getElement().removeClassName("arrowRotateUp");
					arrowDown.getElement().addClassName("arrowRotateDown");
					arrowDown.getElement().addClassName("arrowUp");
					
					parentScrollPanel.refresh();
				}
			}
		};
		
		// setting up possible values
		this.valuePanels = new ArrayList<FocusPanel>();
		this.possibleValues = values;
		for (String cellValue : values) {
			FocusPanel valueP = new FocusPanel();
			Label valueText = new Label();
			valueText.setText(cellValue);
			valueText.setTitle(cellValue);
			valueP.add(valueText);
			
			valueP.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					currentValueText.setText(String.valueOf(((FocusPanel) event.getSource()).getWidget().getElement().getInnerHTML()));

					valuePanelsWrapper.setVisible(false);
					// store value
					String val = currentValueText.getText();
					if(saveInLocalStorage){
						SettingStorage.storeValue(key, val, false);
					}
					value  = val;
					

					arrowDown.getElement().removeClassName("arrowUp");
					arrowDown.getElement().removeClassName("arrowRotateDown");
					arrowDown.getElement().addClassName("arrowRotateUp");
					
					parentScrollPanel.refresh();
				}
			});
			
			this.valuePanels.add(valueP);
		}
		
		// setting up wrapper
		this.valuePanelsWrapper = new WidgetList();
		this.valuePanelsWrapper.setVisible(false);
		this.valuePanelsWrapper.setWidth("65%");
		this.valuePanelsWrapper.getElement().getStyle().setFloat(Style.Float.RIGHT);
		
		for (FocusPanel p : this.valuePanels) {
			this.valuePanelsWrapper.add(p);
		}
	}
	
	@Override
	public Widget asWidget() {
		VerticalPanel wrapper = new VerticalPanel();
		wrapper.setHeight("100%");
		wrapper.setWidth("100%");
		
		HorizontalPanel panel = new HorizontalPanel();
		panel.setWidth("100%");
		panel.add(this.text);
		
		// Value + arrow down symbol in order to show that the user can choose a value in a given value pool.
		HorizontalPanel hValuePanel = new HorizontalPanel();
		hValuePanel.setWidth("100%");
		
		this.focusValuePanel = new FocusPanel();
		this.focusValuePanel.setWidth("100%");
		this.focusValuePanel.addClickHandler(this.handler);
		
		hValuePanel.add(this.valuePanel);
		
		arrowDown = new Label();
		ParagraphElement pElement = Document.get().createPElement();
		pElement.setInnerHTML("<i class='fa fa-chevron-down fa-lg'></i>");
		arrowDown.getElement().appendChild(pElement);
		arrowDown.getElement().getStyle().setFloat(Style.Float.RIGHT);
		hValuePanel.add(arrowDown);
		
		this.focusValuePanel.add(hValuePanel);
		panel.add(focusValuePanel);
		
		// setup 1st cell - label
		panel.getWidget(0).getElement().getParentElement().getParentElement().getParentElement().getParentElement().getStyle().setProperty("tableLayout", "fixed");
		
		panel.getWidget(0).getElement().getStyle().setProperty("overflow", "hidden");
		panel.getWidget(0).getElement().getStyle().setProperty("whiteSpace", "nowrap");
		panel.getWidget(0).getElement().getStyle().setProperty("textOverflow", "ellipsis");
		panel.getWidget(0).getElement().getParentElement().getStyle().setWidth(35, Unit.PCT);
		
		this.setValueFromStorage();
		
		wrapper.add(panel);
		wrapper.add(this.valuePanelsWrapper);
		return wrapper;
	}
	
	@Override
	public void setValueFromStorage() {
		String value = this.possibleValues[0];
		try {
			value = SettingStorage.getValue(this.key, false);
		} catch (Exception e) {
			value = this.possibleValues[0]; 
		}
		currentValueText.setText(value);
	}
	
	public String getValue(){
		return value;
	}

}
