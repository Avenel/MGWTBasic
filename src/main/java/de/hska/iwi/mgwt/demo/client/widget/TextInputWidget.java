package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.MTextBox;

import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Implements a checkbox widget with its missing text.
 * @author Martin
 *
 */
public class TextInputWidget implements IsWidget, InputWidget {

	Label text;
	MTextBox textBox;
	StorageKey key;
	ValueChangeHandler<String> handler;
	
	public TextInputWidget(String text, final StorageKey key) {
		this.text = new Label(text);
		
		this.textBox = new MTextBox();
		this.textBox.setTitle(text);
		this.textBox.getElement().getFirstChildElement().getStyle().setTextAlign(TextAlign.RIGHT);
		
		this.handler = new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// store value in local storage
				Storage stockStore = Storage.getLocalStorageIfSupported();
				
				if (stockStore != null) {
					stockStore.setItem(key.toString(), event.getValue().toString());
				}
			}
			
		};
		textBox.addValueChangeHandler(handler);
		
		this.key = key;
	}
	
	@Override
	public Widget asWidget() {
		HorizontalPanel panel = new HorizontalPanel();
		
		panel.setWidth("100%");
		
		panel.add(this.text);
		panel.add(this.textBox);
		
		// setup 2nd cell
		panel.getWidget(1).getElement().getParentElement().setPropertyString("align", "right");
		panel.getWidget(1).getElement().getParentElement().getStyle().setWidth(75, Unit.PCT);
		
		this.setValueFromStorage();
		
		return panel;
	}
	
	public void setCheckBox(String isChecked) {
		this.textBox.setValue(isChecked);
	}
	
	public void addHandler(ValueChangeHandler<String> handler) {
		this.textBox.addValueChangeHandler(handler);
	}

	@Override
	public void setValueFromStorage() {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		
		if (stockStore != null) {
			this.textBox.setValue(stockStore.getItem(this.key.toString()));
		}
	}

}
