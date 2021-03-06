package de.hska.iwi.mgwt.demo.client.activities.mensa;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.TextAlign;
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
import com.googlecode.mgwt.ui.client.widget.ProgressBar;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.backend.model.MealGroup;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;
import de.hska.iwi.mgwt.demo.client.widget.HeaderSettingsButton;
import de.hska.iwi.mgwt.demo.client.widget.MealGroupWidget;

/**
 * Implementation of the MensaView. Displays the menu for a given amount of days. 
 * @author Martin
 *
 */
public class MensaViewImpl implements MensaView {

	private LayoutPanel main;
	private Map<String, ScrollPanel> menuScrollPanels;
	private Carousel menuCarousel;
	private int maxMenuDays = 5;
	private int menuDaysCounter = 1;
	private HeaderSettingsButton settingsButton;
	private List<String> days;

	/**
	 * Public constructor. Setup class fields.
	 */
	public MensaViewImpl() {
		this.main = new LayoutPanel();
		this.menuScrollPanels = new HashMap<String, ScrollPanel>();
		this.menuCarousel = new Carousel();
		this.days = new ArrayList<String>();
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
		this.menuDaysCounter = 1;
		
		ScrollPanel menuScrollPanel = new ScrollPanel();
		menuScrollPanel.getElement().getStyle().setPaddingBottom(2, Unit.EM);
		
		// add loading screen
		VerticalPanel mealGroups = new VerticalPanel();
		mealGroups.getElement().addClassName("mealGroups-container");
		
		Label loadingLabel = new Label();
		loadingLabel.setText("Lade Menü...");
		loadingLabel.getElement().getStyle().setColor("#DB0134");
		loadingLabel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		loadingLabel.getElement().getStyle().setMarginTop(30, Unit.PCT);
		mealGroups.add(loadingLabel);
		
		ProgressBar pBar = new ProgressBar();
		mealGroups.add(pBar);
		
		// add Date and progressbar
		menuScrollPanel.add(mealGroups);
		this.menuCarousel.add(menuScrollPanel);
		
		// put menu days in map
		Date dueDate = new Date();
		this.days = new ArrayList<String>();
		for (int i = 0; i < this.maxMenuDays; i++) {
			String weekDay = DateTimeFormat.getFormat("E").format(dueDate);
			// Determine if day is not a workday (Perhaps not the best way...)
			while (weekDay.contains("S")) {
				CalendarUtil.addDaysToDate(dueDate, 1);
				weekDay = DateTimeFormat.getFormat("E").format(dueDate);
			}
			String dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
			this.days.add(dueDateString);
			this.menuScrollPanels.put(dueDateString, null);
			CalendarUtil.addDaysToDate(dueDate, 1);
		}
			
		main.add(this.menuCarousel);
		
		return this.main;
	}
	
	/**
	 * Generate Scrollpanel in MensaView for given mensaMenu
	 * @param mensaMenu
	 */
	private void generateMensaMenueView(MensaMenu mensaMenu) {
		if (mensaMenu != null) {
			ScrollPanel menuScrollPanel = new ScrollPanel();

			VerticalPanel mealGroups = new VerticalPanel();
			mealGroups.getElement().addClassName("mealGroups-container");
			
			// add Date
			mealGroups.add(createDateWidget(mensaMenu.getDate()));
			
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

			this.menuScrollPanels.put(mensaMenu.getDate(), menuScrollPanel);

			// if all menus arrived, refresh carousel
			if (this.menuDaysCounter == this.maxMenuDays) {
				main.remove(this.menuCarousel);
				
				this.menuCarousel = new Carousel();
				
				for (String day : this.days) {
					menuScrollPanel = this.menuScrollPanels.get(day);
					if (menuScrollPanel != null) {
						this.menuCarousel.add(menuScrollPanel);
					}
				}
				
				main.add(this.menuCarousel);
			}
			
		}
	}
	
	/**
	 * Setter for a given mensa menu.
	 * @param mensaMenu
	 */
	public void setMensaMenu(MensaMenu mensaMenu) {
		generateMensaMenueView(mensaMenu);
		this.menuDaysCounter++;
	}

	/**
	 * Creates a Date label.
	 * @param date
	 * @return Widget dateLabel
	 */
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

	@Override
	public void displayConnectionError() {
		this.menuCarousel.clear();
		
		Label errorMessage = new Label();
		errorMessage.setText("Der Server ist zur Zeit nicht erreichbar. Versuche es später erneut!");
		errorMessage.getElement().getStyle().setColor("#DB0134");
		errorMessage.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		errorMessage.getElement().getStyle().setWidth(80, Unit.PCT);
		errorMessage.getElement().getStyle().setProperty("margin", "auto");
		errorMessage.getElement().getStyle().setMarginTop(40, Unit.PCT);
		
		this.menuCarousel.add(errorMessage);
	}
	
}
