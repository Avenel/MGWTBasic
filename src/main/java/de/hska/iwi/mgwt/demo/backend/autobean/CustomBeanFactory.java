package de.hska.iwi.mgwt.demo.backend.autobean;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface CustomBeanFactory extends AutoBeanFactory {
	
	AutoBean<INewsBoard> newsBoard();
	AutoBean<INews> news();
	
	AutoBean<Meal> meal();
	AutoBean<MealGroup> mealGroup();
	AutoBean<MensaMenu> mensaMenu();
	
}
