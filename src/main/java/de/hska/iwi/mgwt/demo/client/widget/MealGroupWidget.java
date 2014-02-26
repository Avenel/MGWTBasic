package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

import de.hska.iwi.mgwt.demo.backend.constants.FoodAdditive;
import de.hska.iwi.mgwt.demo.backend.model.Meal;
import de.hska.iwi.mgwt.demo.backend.model.MealGroup;
import de.hska.iwi.mgwt.demo.client.dialog.MensaRatingDialog;
import de.hska.iwi.mgwt.demo.client.model.MensaPriceCategory;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * This widget represents a Mensa MealGroup.
 * It has for each meal a horizontal line with a food-icon,
 * name, its rating and its price.
 * 
 * @author Martin
 *
 */
public class MealGroupWidget implements IsWidget {

	private VerticalPanel main;  
	private MealGroup mealGroup;
	private Label title;
	private HorizontalPanel titleBar;
	
	/**
	 * Public constructor. Setting up widget with the given meals.
	 * @param mealgroup
	 */
	public MealGroupWidget(MealGroup mealgroup) {
		this.mealGroup = mealgroup;
		
		this.main = new VerticalPanel();
		this.main.getElement().addClassName("mealGroup-container");
		
		// titlebar
		titleBar = new HorizontalPanel();
		titleBar.getElement().addClassName("mealGroup-titlebar");
		titleBar.getElement().getStyle().setPaddingBottom(0.1, Unit.EM);
		
		// title
		this.title = new Label();
		this.title.setText(this.mealGroup.getTitle());
		this.title.getElement().addClassName("mealGroup-title");
		
		titleBar.add(title);
		this.main.add(titleBar);
		
		WidgetList lineList = new WidgetList();
		
		// meals
		for (Meal meal : this.mealGroup.getMeals()) {
			FocusPanel wrapperFocusPanel = new FocusPanel();
			
			// if user clicks on meal, show rating dialog
			wrapperFocusPanel.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					MensaRatingDialog ratingDialog = new MensaRatingDialog();
					ratingDialog.show();
				}
				
			});
			
			HorizontalPanel line = new HorizontalPanel();
			line.getElement().addClassName("meal-container");
			
			// icon for meal modifier (pig, cow, vegan, vegetarian)
			HorizontalPanel mealModifiers = new HorizontalPanel();
			mealModifiers.getElement().addClassName("meal-modifiers-container");
			mealModifiers.getElement().getStyle().setVerticalAlign(VerticalAlign.MIDDLE);
			
			// meal contains cow meat
			List<FoodAdditive> foodAdditiveNumbers = meal.getFoodAdditiveNumbersAsEnum();
			if (foodAdditiveNumbers != null && foodAdditiveNumbers.size() > 0) {
				
				for (FoodAdditive fa : foodAdditiveNumbers) {
					if (fa.equals(FoodAdditive.ENTHAELT_RINDFLEISCH)) {
						LayoutPanel cow = new LayoutPanel();
						cow.getElement().addClassName("meal-cow");
						mealModifiers.add(cow);
					}
					
					// meal contains cow welfare meat
					if (fa.equals(FoodAdditive.ENTHAELT_RINDFLEISCH_ARTGERECHT)) {
						LayoutPanel cow = new LayoutPanel();
						cow.getElement().addClassName("meal-cow-welfare");
						mealModifiers.add(cow);
					}
					
					// meal contains pig meat
					if (fa.equals(FoodAdditive.ENTHAELT_SCHWEINEFLEISCH)) {
						LayoutPanel pig = new LayoutPanel();
						pig.getElement().addClassName("meal-pig");
						mealModifiers.add(pig);
					}
					
					// vegetarian meal
					if (fa.equals(FoodAdditive.VEGETARISCHES_GERICHT)) {
						LayoutPanel vegetarian = new LayoutPanel();
						vegetarian.getElement().addClassName("meal-vegetarian");
						mealModifiers.add(vegetarian);
					}
					
					// vegan meal
					if (fa.equals(FoodAdditive.VEGANES_GERICHT)) {
						LayoutPanel vegan = new LayoutPanel();
						vegan.getElement().addClassName("meal-vegan");
						mealModifiers.add(vegan);
					}
					
					// msc meal
					if (fa.equals(FoodAdditive.MSC_ZERTIFIZIERTER_FISCH)) {
						LayoutPanel msc = new LayoutPanel();
						msc.getElement().addClassName("meal-msc");
						mealModifiers.add(msc);
					}
					
					// bio meal
					if (fa.equals(FoodAdditive.KONTROLLIERTER_BIO_ANBAU)) {
						LayoutPanel bio = new LayoutPanel();
						bio.getElement().addClassName("meal-bio");
						mealModifiers.add(bio);
					}
				}
				
				
			}

			HorizontalPanel ratingNamePanel = new HorizontalPanel();
			ratingNamePanel.getElement().getStyle().setFloat(Style.Float.LEFT);
			
			// rating		
			Label ratingStar = new Label();
			ratingStar.getElement().getStyle().setFloat(Style.Float.RIGHT);
			ratingStar.getElement().getStyle().setTextAlign(TextAlign.CENTER);
			ParagraphElement pElementStar = Document.get().createPElement();
			
			double rating = (Math.random() * 10) % 5;
			String fontAwesomeStar = "fa-star-half-o";
			if (rating < 2) fontAwesomeStar = "fa-star-o";
			if (rating > 2 && rating < 4.5) fontAwesomeStar = "fa-star-half-o";
			if (rating > 4.5) fontAwesomeStar = "fa-star";
			
			pElementStar.setInnerHTML("<i class='fa " + fontAwesomeStar + " fa-lg' style='color:#DB0134;'></i>");
			ratingStar.getElement().appendChild(pElementStar);
			
			NumberFormat fmt = NumberFormat.getFormat("0.0");
			ParagraphElement pElementRating = Document.get().createPElement();
			pElementRating.setInnerHTML("<p style='font-size:0.9em; float:right;'>" + fmt.format(rating).replace(".", ",") + "</p>");
			pElementRating.getStyle().setColor("#DB0134");
			ratingStar.getElement().appendChild(pElementRating);
			
			ratingNamePanel.add(ratingStar);
			
			// name
			Label name = new Label();
			name.setText(meal.getName());
			name.getElement().addClassName("meal-name");
			
			ratingNamePanel.add(name);
			line.add(ratingNamePanel);
			
			HorizontalPanel modifierPricePanel = new HorizontalPanel();
			modifierPricePanel.getElement().getStyle().setFloat(Style.Float.RIGHT);
			
			modifierPricePanel.add(mealModifiers);		
			line.setCellHorizontalAlignment(mealModifiers, HorizontalAlignmentConstant.startOf(Direction.RTL));
			
			// price
			Label price = new Label();
			double priceInEuro = meal.getPriceStudent();
			
			// Set price dependent on chosen price category
			String priceCategory = "";
			try {
				priceCategory = SettingStorage.getValue(StorageKey.MENSAPRICECATEGORY, false);
			} catch (Exception e) {
				// standard: Student
				priceCategory = "Student";
			}
			
			MensaPriceCategory priceCategoryEnum = MensaPriceCategory.getByString(priceCategory);
			
			switch (priceCategoryEnum) {
				case STUDENT:
					priceInEuro = meal.getPriceStudent();
					break;
				case EMPLOYEE:
					priceInEuro = meal.getPriceEmployee();
					break;
				case PUPIL:
					priceInEuro = meal.getPricePupil();
					break;
				case GUEST:
					priceInEuro = meal.getPriceGuest();
					break;
				default:
					priceInEuro = meal.getPriceStudent();
			}
			
			price.setText(NumberFormat.getFormat("#0.00").format(priceInEuro).replace(".",  ",") + " €");
			price.getElement().addClassName("meal-price");
			modifierPricePanel.add(price);
			
			line.add(modifierPricePanel);	
			
			wrapperFocusPanel.add(line);
			
			lineList.add(wrapperFocusPanel);
		}
		
		main.add(lineList);

	}
	
	@Override
	public Widget asWidget() {		
		return this.main;
	}
	
	

}
