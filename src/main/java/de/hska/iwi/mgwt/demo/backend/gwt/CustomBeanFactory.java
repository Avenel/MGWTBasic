package de.hska.iwi.mgwt.demo.backend.gwt;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;

public interface CustomBeanFactory extends AutoBeanFactory {
	
	AutoBean<NewsBoardJSON> newsBoard();
	
	AutoBean<NewsJSON> news();

}
