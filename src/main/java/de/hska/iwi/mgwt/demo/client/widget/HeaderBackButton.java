package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class HeaderBackButton implements IsWidget {

	@Override
	public Widget asWidget() {
		HeaderButton backButton = new HeaderButton();
		backButton.setBackButton(true);
		backButton.setText("");
		

		// handle history back
		backButton.addTapHandler(new TapHandler(){
			@Override
			public void onTap(TapEvent event) {
				History.back();
			}
		});
		
		return backButton;
	}

}
