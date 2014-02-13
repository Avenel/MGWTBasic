package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.ITutorials;
import de.hska.iwi.mgwt.demo.backend.model.Tutorials;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class TutorialsCallback extends AbstractRequestCallback<ObserverActivity<Tutorials>>{

	public TutorialsCallback(ObserverActivity<Tutorials> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<ITutorials> bean = AutoBeanCodex.decode(factory, ITutorials.class, "{\"tutorials\": " + json + "}");

		observer.update(new Tutorials(bean.as()));
	}

}
