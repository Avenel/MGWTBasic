package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;

import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Implements a checkbox widget.
 * @author Martin
 *
 */
public class CheckBoxWidget implements IsWidget, InputWidget {

	Label text;
	MCheckBox checkbox;
	ValueChangeHandler<Boolean> handler;
	StorageKey key;
	
	/**
	 * Public constructor, setting up checkbox label (name), StorageKey and the widget itself.
	 * @param text
	 * @param key
	 */
	public CheckBoxWidget(String text, final StorageKey key) {
		this.text = new Label(text);
		
		// setup wordrwrap
		this.text.getElement().getStyle().setProperty("overflow", "hidden");
		this.text.getElement().getStyle().setProperty("whiteSpace", "nowrap");
		this.text.getElement().getStyle().setProperty("textOverflow", "ellipsis");
		
		this.checkbox = new MCheckBox();
		this.checkbox.setTitle(text);
		
		this.handler = new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// store value in local storage
				SettingStorage.storeValue(key, event.getValue().toString(), false);
			}
			
		};
		
		this.addHandler(handler);
		this.key = key;
	}
	
	@Override
	public Widget asWidget() {
		HorizontalPanel panel = new HorizontalPanel();
		
		panel.setWidth("100%");
		
		panel.add(this.text);
		panel.add(this.checkbox);
		
		// setup table layout: fixed
		panel.getWidget(0).getElement().getParentElement().getParentElement().getParentElement().getParentElement().getStyle().setProperty("tableLayout", "fixed");
		
		// setup 2nd cell
		panel.getWidget(1).getElement().getParentElement().setPropertyString("align", "right");
		
		setValueFromStorage();
		
		return panel;
		
	}
	
	/**
	 * Setter for value of checkbox.
	 * @param Boolean isChecked
	 */
	public void setCheckBox(boolean isChecked) {
		this.checkbox.setValue(isChecked);
	}
	
	/**
	 * Adds ValueChanged handler. 
	 * @param handler
	 */
	public void addHandler(ValueChangeHandler<Boolean> handler) {
		this.checkbox.addValueChangeHandler(handler);
	}
	
	@Override
	public void setValueFromStorage() {
		try {
			this.checkbox.setValue(Boolean.parseBoolean(SettingStorage.getValue(key, false)));
		} catch (Exception e) {
			this.checkbox.setValue(false);
		}
	}

}
