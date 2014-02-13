package de.hska.iwi.mgwt.demo.backend.autobean;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface CustomBeanFactory extends AutoBeanFactory {
	
	AutoBean<INewsBoard> newsBoard();
	AutoBean<INews> news();
	
	AutoBean<MensaMenu> mensaMenu();
	AutoBean<MealGroup> mealGroup();
	AutoBean<Meal> meal();
	
	AutoBean<IWorkflowInformation> workflowInformation();
	
	AutoBean<ITutorials> tutorials();
	AutoBean<ITutorial> tutorial();
}
