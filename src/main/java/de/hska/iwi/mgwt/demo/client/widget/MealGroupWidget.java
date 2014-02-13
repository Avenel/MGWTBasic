package de.hska.iwi.mgwt.demo.client.widget;

import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hska.iwi.mgwt.demo.backend.constants.FoodAdditive;
import de.hska.iwi.mgwt.demo.backend.model.Meal;
import de.hska.iwi.mgwt.demo.backend.model.MealGroup;

/**
 * This widget represents a Mensa MealGroup.
 * It has for each meal a horizontal line with a food-icon,
 * name and its price.
 * 
 * @author Martin
 *
 */
public class MealGroupWidget implements IsWidget {

	private VerticalPanel main;  
	private MealGroup mealGroup;
	private Label title;
	private HorizontalPanel titleBar;
	
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
		
		// rating		
		Label ratingStar = new Label();
		ratingStar.getElement().getStyle().setFloat(Style.Float.RIGHT);
		ratingStar.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		ParagraphElement pElementStar = Document.get().createPElement();
		pElementStar.setInnerHTML("<i class='fa fa-star-half-o fa-2x' style='color:#DB0134;'></i>");
		ratingStar.getElement().appendChild(pElementStar);
		
		NumberFormat fmt = NumberFormat.getFormat("0.0");
		ParagraphElement pElementRating = Document.get().createPElement();
		pElementRating.setInnerHTML("<p style='font-size:0.9em'>" + fmt.format((Math.random() * 10) % 5).replace(".", ",") + "</p>");
		pElementRating.getStyle().setColor("#DB0134");
		ratingStar.getElement().appendChild(pElementRating);
		
		titleBar.add(ratingStar);
		
		this.main.add(titleBar);
		
		// meals
		for (Meal meal : this.mealGroup.getMeals()) {
			HorizontalPanel line = new HorizontalPanel();
			line.getElement().addClassName("meal-container");
			
			// icon for meal modifier (pig, cow, vegan, vegetarian)
			HorizontalPanel mealModifiers = new HorizontalPanel();
			mealModifiers.getElement().addClassName("meal-modifiers-container");
			
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

			line.add(mealModifiers);		
			line.setCellWidth(line.getWidget(0), "40px");
			line.setCellHorizontalAlignment(mealModifiers, HorizontalAlignmentConstant.startOf(Direction.RTL));
			
			Label name = new Label();
			name.setText(meal.getName());
			name.getElement().addClassName("meal-name");
			line.add(name);
			
			Label price = new Label();
			price.setText(NumberFormat.getFormat("#0.00").format(meal.getPriceStudent()).replace(".",  ",") + " €");
			price.getElement().addClassName("meal-price");
			line.add(price);
			
			main.add (line);
		}
			

	}
	
	@Override
	public Widget asWidget() {		
		return this.main;
	}
	
	

}
