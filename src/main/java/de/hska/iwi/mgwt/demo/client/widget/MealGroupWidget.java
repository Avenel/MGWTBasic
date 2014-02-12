package de.hska.iwi.mgwt.demo.client.widget;

import org.cobogw.gwt.user.client.ui.Rating;

import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hska.iwi.mgwt.demo.backend.autobean.Meal;
import de.hska.iwi.mgwt.demo.backend.autobean.MealGroup;

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
	
	public MealGroupWidget(MealGroup mealgroup) {
		this.mealGroup = mealgroup;
		
		this.main = new VerticalPanel();
		this.main.getElement().addClassName("mealGroup-container");
		
		// titlebar
		HorizontalPanel titleBar = new HorizontalPanel();
		titleBar.getElement().addClassName("mealGroup-titlebar");
		
		// title
		this.title = new Label();
		this.title.setText(this.mealGroup.getTitle());
		this.title.getElement().addClassName("mealGroup-title");
		titleBar.add(title);
		
		// rating
		Rating rating = new Rating((int)(Math.random() * 10) % 5, 5);
		rating.getElement().addClassName("mealGroup-rating");
		titleBar.add(rating);
		titleBar.setCellHorizontalAlignment(rating, HorizontalAlignmentConstant.startOf(Direction.RTL));
		titleBar.setCellVerticalAlignment(rating, HasVerticalAlignment.ALIGN_MIDDLE);  
		
		this.main.add(titleBar);
		
		// meals
		for (Meal meal : this.mealGroup.getMeals()) {
			HorizontalPanel line = new HorizontalPanel();
			line.getElement().addClassName("meal-container");
			
			// icon for meal modifier (pig, cow, vegan, vegetarian)
			HorizontalPanel mealModifiers = new HorizontalPanel();
			mealModifiers.getElement().addClassName("meal-modifiers-container");
			
			// meal contains cow meat
			if (meal.getFoodAdditiveNumbers().contains(93)) {
				LayoutPanel cow = new LayoutPanel();
				cow.getElement().addClassName("meal-cow");
				mealModifiers.add(cow);
			}
			
			// meal contains cow welfare meat
			if (meal.getFoodAdditiveNumbers().contains(94)) {
				LayoutPanel cow = new LayoutPanel();
				cow.getElement().addClassName("meal-cow-welfare");
				mealModifiers.add(cow);
			}
			
			// meal contains pig meat
			if (meal.getFoodAdditiveNumbers().contains(95)) {
				LayoutPanel pig = new LayoutPanel();
				pig.getElement().addClassName("meal-pig");
				mealModifiers.add(pig);
			}
			
			// vegetarian meal
			if (meal.getFoodAdditiveNumbers().contains(96)) {
				LayoutPanel vegetarian = new LayoutPanel();
				vegetarian.getElement().addClassName("meal-vegetarian");
				mealModifiers.add(vegetarian);
			}
			
			// vegan meal
			if (meal.getFoodAdditiveNumbers().contains(97)) {
				LayoutPanel vegan = new LayoutPanel();
				vegan.getElement().addClassName("meal-vegan");
				mealModifiers.add(vegan);
			}
			
			// msc meal
			if (meal.getFoodAdditiveNumbers().contains(98)) {
				LayoutPanel msc = new LayoutPanel();
				msc.getElement().addClassName("meal-msc");
				mealModifiers.add(msc);
			}
			
			// bio meal
			if (meal.getFoodAdditiveNumbers().contains(99)) {
				LayoutPanel bio = new LayoutPanel();
				bio.getElement().addClassName("meal-bio");
				mealModifiers.add(bio);
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
