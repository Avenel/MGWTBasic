package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.MCheckBox;

/**
 * Implements a checkbox widget with its missing text.
 * @author Martin
 *
 */
public class CheckBoxWidget implements IsWidget {

	Label text;
	MCheckBox checkbox;
	ValueChangeHandler<Boolean> handler;
	
	public CheckBoxWidget(String text) {
		this.text = new Label(text);
		
		this.checkbox = new MCheckBox();
		this.checkbox.setTitle(text);
		
		this.handler = null;
		
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
		
		
		return panel;
		
	}
	
	public void setCheckBox(boolean isChecked) {
		this.checkbox.setValue(isChecked);
	}
	
	public void addHandler(ValueChangeHandler<Boolean> handler) {
		this.checkbox.addValueChangeHandler(handler);
	}

}