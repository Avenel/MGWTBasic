package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.ITimetable;
import de.hska.iwi.mgwt.demo.backend.model.Timetable;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class TimetableCallback extends AbstractRequestCallback<ObserverActivity<Timetable>> {

	public TimetableCallback(ObserverActivity<Timetable> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<ITimetable> bean = AutoBeanCodex.decode(factory, ITimetable.class, json);
		
		observer.update(new Timetable(bean.as()));
	}

}
