package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.backend.model.MealGroup;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.MealGroupWidget;

public class MensaViewImpl implements MensaView {

	private LayoutPanel main;
	
	private MensaMenu mensaMenu;

	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Mensa");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		// Caroussel: for each day a page on a scrollpanel
		Carousel carousel = new Carousel();
		ScrollPanel scrollPanel = new ScrollPanel();
		
		VerticalPanel mealGroups = new VerticalPanel();
		mealGroups.getElement().addClassName("mealGroups-container");
		
		for (MealGroup mealGroup : this.mensaMenu.getMealGroups()) {
			MealGroupWidget mw = new MealGroupWidget(mealGroup);
			mealGroups.add(mw);
		}
		
		
		scrollPanel.add(mealGroups);
		carousel.add(scrollPanel);
		main.add(carousel);
		
		return this.main;
	}

	public void setMensaMenu(MensaMenu mensaMenu) {
		this.mensaMenu = mensaMenu;
	}

}
