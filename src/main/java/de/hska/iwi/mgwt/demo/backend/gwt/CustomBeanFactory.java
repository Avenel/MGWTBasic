package de.hska.iwi.mgwt.demo.backend.gwt;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface CustomBeanFactory extends AutoBeanFactory {
	
	AutoBean<News> news();

}
