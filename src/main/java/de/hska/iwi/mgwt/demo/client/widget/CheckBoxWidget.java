package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;

import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Implements a checkbox widget with its missing text.
 * @author Martin
 *
 */
public class CheckBoxWidget implements IsWidget, InputWidget {

	Label text;
	MCheckBox checkbox;
	ValueChangeHandler<Boolean> handler;
	StorageKey key;
	
	public CheckBoxWidget(String text, final StorageKey key) {
		this.text = new Label(text);
		
		this.checkbox = new MCheckBox();
		this.checkbox.setTitle(text);
		
		this.handler = new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// store value in local storage
				Storage stockStore = Storage.getLocalStorageIfSupported();
				
				if (stockStore != null) {
					stockStore.setItem(key.toString(), event.getValue().toString());
				}
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
		
		// setup 2nd cell
		panel.getWidget(1).getElement().getParentElement().setPropertyString("align", "right");
		panel.getWidget(1).getElement().getParentElement().getStyle().setWidth(75, Unit.PCT);
		
		setValueFromStorage();
		
		return panel;
		
	}
	
	public void setCheckBox(boolean isChecked) {
		this.checkbox.setValue(isChecked);
	}
	
	public void addHandler(ValueChangeHandler<Boolean> handler) {
		this.checkbox.addValueChangeHandler(handler);
	}
	
	@Override
	public void setValueFromStorage() {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		
		if (stockStore != null) {
			this.checkbox.setValue(Boolean.parseBoolean(stockStore.getItem(this.key.toString())));
		}
	}

}
