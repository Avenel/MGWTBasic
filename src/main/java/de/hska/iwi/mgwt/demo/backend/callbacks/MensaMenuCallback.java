package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.IMensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
/**
 * Responsible for creating the {@link MensaMenu}-Model.
 * @author Nico
 *
 */
public class MensaMenuCallback extends AbstractRequestCallback<ObserverActivity<MensaMenu>> {

	public MensaMenuCallback(ObserverActivity<MensaMenu> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<IMensaMenu> bean = AutoBeanCodex.decode(factory, IMensaMenu.class, json);
		
		observer.update(new MensaMenu(bean.as()));
		
	}

}
