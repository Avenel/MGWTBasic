package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.MSlider;

import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class SliderInputWidget implements IsWidget, InputWidget {

	Label text;
	MSlider slider;
	Label valueText;
	StorageKey key;
	ValueChangeHandler<Integer> handler;
	int min;
	
	/**
	 * Public constructor. Setting up widget.
	 * @param text
	 * @param key
	 * @param max
	 */
	public SliderInputWidget (String text, final StorageKey key, final int min, final int max) {
		this.text = new Label(text);		
		
		this.slider = new MSlider();
		this.slider.setTitle(text);
		this.slider.getElement().getFirstChildElement().getStyle().setTextAlign(TextAlign.LEFT);
		
		this.min = min;
		this.slider.setMax(max);
		
		this.handler = new ValueChangeHandler<Integer>() {
			@Override
			public void onValueChange(ValueChangeEvent<Integer> event) {
				int currVal = event.getValue();
				int settingVal = (currVal + min > max) ? max : currVal + min;
				SettingStorage.storeValue(key, String.valueOf(settingVal), false);
				valueText.setText(String.valueOf(settingVal));
			}
		};
		this.slider.addValueChangeHandler(handler);
		
		this.valueText = new Label();
		this.valueText.setText(String.valueOf(min));
		this.valueText.getElement().getStyle().setPaddingBottom(0.5, Unit.EM);
		
		this.key = key;
	}
	
	@Override
	public Widget asWidget() {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setWidth("100%");
		
		panel.add(this.text);
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.getElement().getStyle().setFloat(Style.Float.RIGHT);
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.add(this.valueText);
		vPanel.add(this.slider);
	
		panel.add(vPanel);
		
		// setup 1st cell - label
		panel.getWidget(0).getElement().getParentElement().getParentElement().getParentElement().getParentElement().getStyle().setProperty("tableLayout", "fixed");
		
		panel.getWidget(0).getElement().getStyle().setProperty("overflow", "hidden");
		panel.getWidget(0).getElement().getStyle().setProperty("whiteSpace", "nowrap");
		panel.getWidget(0).getElement().getStyle().setProperty("textOverflow", "ellipsis");
		panel.getWidget(0).getElement().getParentElement().getStyle().setWidth(35, Unit.PCT);
		
		// setup 2nd cell
		panel.getWidget(1).getElement().getParentElement().getFirstChildElement().getFirstChildElement().getStyle().setWidth(100, Unit.PCT);
		
		this.setValueFromStorage();
		
		return panel;
	}
	
	@Override
	public void setValueFromStorage() {
		try {
			this.slider.setValue(Integer.valueOf(SettingStorage.getValue(key, false)));
		} catch (Exception e) {
			this.slider.setValue(this.min);
		}
		
		valueText.setText(String.valueOf(slider.getValue()));
	}

}
