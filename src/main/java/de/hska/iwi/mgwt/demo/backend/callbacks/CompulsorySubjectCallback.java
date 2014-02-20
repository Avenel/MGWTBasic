package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.ICompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
/**
 * Responsible for creating the {@link CompulsoryOptionalSubjects}-Model.
 * @author Nico
 *
 */
public class CompulsorySubjectCallback extends AbstractRequestCallback<ObserverActivity<CompulsoryOptionalSubjects>> {

	public CompulsorySubjectCallback(ObserverActivity<CompulsoryOptionalSubjects> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<ICompulsoryOptionalSubjects> bean = AutoBeanCodex.decode(factory,
																		  ICompulsoryOptionalSubjects.class, 
																		  "{\"compulsorySubjects\": " + json + "}");
		
		observer.update(new CompulsoryOptionalSubjects(bean.as()));
	}
	

}
