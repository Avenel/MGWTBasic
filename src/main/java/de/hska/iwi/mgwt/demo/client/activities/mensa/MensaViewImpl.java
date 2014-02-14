package de.hska.iwi.mgwt.demo.client.activities.mensa;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.backend.model.MealGroup;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderSettingsButton;
import de.hska.iwi.mgwt.demo.client.widget.MealGroupWidget;

public class MensaViewImpl implements MensaView {

	private LayoutPanel main;
	private Map<String, ScrollPanel> menuScrollPanels;
	private Carousel menuCarousel;
	private int maxMenuDays = 5;
	private int menuDaysCounter = 1;
	private HeaderSettingsButton settingsButton;

	public MensaViewImpl() {
		this.settingsButton = new HeaderSettingsButton();
	}
	
	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Mensa");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		headerPanel.setRightWidget(settingsButton.asWidget());
		
		// Caroussel: for each day a page on a scrollpanel
		this.menuCarousel = new Carousel();
		this.menuScrollPanels = new HashMap<String, ScrollPanel>();
		ScrollPanel menuScrollPanel = new ScrollPanel();
		menuScrollPanel.getElement().getStyle().setPaddingBottom(2, Unit.EM);
		
		this.menuDaysCounter = 1;
		
		// add first date
		VerticalPanel mealGroups = new VerticalPanel();
		mealGroups.getElement().addClassName("mealGroups-container");
		
		// add Date
		final Date dueDate = new Date();
		String dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
		
		String weekDay = DateTimeFormat.getFormat("E").format(dueDate);
		System.out.println(weekDay);
		
		// Determine if day is not a workday (Perhaps not the best way...) 
		if (weekDay.contains("S")) {
			CalendarUtil.addDaysToDate(dueDate, 2);
			dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
			System.out.println("true! " + dueDateString);
		}
		
		mealGroups.add(createDateWidget(DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate)));
		menuScrollPanel.add(mealGroups);
		
		Label loadingLabel = new Label();
		loadingLabel.setText("Lade Menü...");
		loadingLabel.getElement().getStyle().setColor("grey");
		mealGroups.add(loadingLabel);
		
		this.menuCarousel.add(menuScrollPanel);
		System.out.println("put: " + dueDateString);
		this.menuScrollPanels.put(dueDateString, menuScrollPanel);
			
		main.add(this.menuCarousel);
		
		return this.main;
	}
	
	/**
	 * Generate Scrollpanel in MensaView for given mensaMenu
	 * @param mensaMenu
	 */
	private void generateMensaMenueView(MensaMenu mensaMenu) {
		if (mensaMenu != null) {
			System.out.println("got menu for: " + mensaMenu.getDate());
			ScrollPanel menuScrollPanel = this.menuScrollPanels.get(mensaMenu.getDate());
			boolean newMenu = false;
			
			if (menuScrollPanel == null) {
				menuScrollPanel = new ScrollPanel();
				newMenu = true;
			} else {
				menuScrollPanel.clear();
			}
			
			VerticalPanel mealGroups = new VerticalPanel();
			mealGroups.getElement().addClassName("mealGroups-container");
			
			// add Date
			Label date = new Label();
			date.getElement().addClassName("mealGroups-date");
			Date parsedDate = DateTimeFormat.getFormat("yyyy-MM-dd").parse(mensaMenu.getDate());
			
			date.setText(DateTimeFormat.getFormat("EEE dd.MM").format(parsedDate));
			mealGroups.add(date);
			
			List<MealGroup> meals = mensaMenu.getMealGroups();
			if (meals != null && meals.size() > 0) {
				for (MealGroup mealGroup : meals) {
					MealGroupWidget mw = new MealGroupWidget(mealGroup);
					mealGroups.add(mw);
					
					// add separator
					if (mealGroup != mensaMenu.getMealGroups().get(mensaMenu.getMealGroups().size()-1)) {
						LayoutPanel separator = new LayoutPanel();
						separator.getElement().addClassName("mealGroup-separator");
						mealGroups.add(separator);
					} else {
						mw.asWidget().getElement().getStyle().setPaddingBottom(2, Unit.EM);
					}
				}
			}
			
			menuScrollPanel.add(mealGroups);
			
			if (newMenu) {
				System.out.println("new menu!");
				this.menuScrollPanels.put(mensaMenu.getDate(), menuScrollPanel);
				this.menuCarousel.add(menuScrollPanel);
			}
			
			// if all menus arrived, refresh carousel
			if (this.menuDaysCounter == this.maxMenuDays) {
				main.remove(this.menuCarousel);
				main.add(this.menuCarousel);
			}
			
		}
	}
	
	public void setMensaMenu(MensaMenu mensaMenu) {
		generateMensaMenueView(mensaMenu);
		this.menuDaysCounter++;
	}

	private Widget createDateWidget(String date) {
		// add Date
		Label dateLabel = new Label();
		dateLabel.getElement().addClassName("mealGroups-date");
		Date parsedDate = DateTimeFormat.getFormat("yyyy-MM-dd").parse(date);		
		dateLabel.setText(DateTimeFormat.getFormat("EEE dd.MM").format(parsedDate));
		
		return dateLabel;
	}

	@Override
	public void setMaxMenuDays(int maxDays) {
		this.maxMenuDays = maxDays;
	}

	@Override
	public void addTapHandlerToSettingsButton(TapHandler handler) {
		this.settingsButton.setTapHandler(handler);
	}
	
}
