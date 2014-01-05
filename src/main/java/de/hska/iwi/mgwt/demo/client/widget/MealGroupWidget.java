package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

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
	
	public MealGroupWidget(MealGroup mealgroup) {
		this.mealGroup = mealgroup;
		
		this.main = new VerticalPanel();
		this.main.getElement().addClassName("mealGroup-container");
		
		// title
		this.title = new Label();
		this.title.setText(this.mealGroup.getTitle());
		this.title.getElement().addClassName("mealGroup-title");
		this.main.add(title);
		
		// meals
		for (Meal meal : this.mealGroup.getMeals()) {
			HorizontalPanel line = new HorizontalPanel();
			line.getElement().addClassName("mealGroup-container");
			
			Label name = new Label();
			name.setText(meal.getName());
			name.getElement().addClassName("meal-name");
			line.add(name);
			
			Label price = new Label();
			price.setText(meal.getPriceStudent().toString());
			price.getElement().addClassName("meal-price");
			line.add(price);
			
			main.add(line);
		}
	}
	
	@Override
	public Widget asWidget() {
		return this.main;
	}
	
	

}
