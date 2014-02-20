package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.IConsultationHours;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHours;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
/**
 * Responsible for creating the {@link ConsultationHours}-Model.
 * @author Nico
 *
 */
public class ConsultationHoursCallback extends AbstractRequestCallback<ObserverActivity<ConsultationHours>> {

	public ConsultationHoursCallback(ObserverActivity<ConsultationHours> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<IConsultationHours> bean = AutoBeanCodex.decode(factory,
																 IConsultationHours.class, 
																 "{\"consultationHours\": " + json + "}");
		
		observer.update(new ConsultationHours(bean.as()));
	}

}
