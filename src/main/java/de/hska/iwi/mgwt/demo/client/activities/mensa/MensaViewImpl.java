package de.hska.iwi.mgwt.demo.client.activities.mensa;

import java.util.Date;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
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
	
	private List<MensaMenu> mensaMenus;

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
		
		for (MensaMenu mensaMenu : this.mensaMenus) {
			ScrollPanel scrollPanel = new ScrollPanel();
			
			VerticalPanel mealGroups = new VerticalPanel();
			mealGroups.getElement().addClassName("mealGroups-container");
			
			// add Date
			Label date = new Label();
			date.getElement().addClassName("mealGroups-date");
			Date parsedDate = DateTimeFormat.getFormat("yyyy-mm-dd").parse(mensaMenu.getDate());
			
			date.setText(DateTimeFormat.getFormat("EEE dd.mm").format(parsedDate));
			mealGroups.add(date);
			
			for (MealGroup mealGroup : mensaMenu.getMealGroups()) {
				MealGroupWidget mw = new MealGroupWidget(mealGroup);
				mealGroups.add(mw);
				
				// add separator
				if (mealGroup != mensaMenu.getMealGroups().get(mensaMenu.getMealGroups().size()-1)) {
					LayoutPanel separator = new LayoutPanel();
					separator.getElement().addClassName("mealGroup-separator");
					mealGroups.add(separator);
				}
			}
			
			scrollPanel.add(mealGroups);
			carousel.add(scrollPanel);
		}
		
		main.add(carousel);
		
		return this.main;
	}

	public void setMensaMenu(List<MensaMenu> mensaMenus) {
		this.mensaMenus = mensaMenus;
	}

}
