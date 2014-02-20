package de.hska.iwi.mgwt.demo.backend.callbacks;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.IBlockCourses;
import de.hska.iwi.mgwt.demo.backend.model.BlockCourses;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
/**
 * Responsible for creating the {@link BlockCourses}-Model.
 * @author Nico
 *
 */
public class BlockCoursesCallback extends AbstractRequestCallback<ObserverActivity<BlockCourses>> {

	public BlockCoursesCallback(ObserverActivity<BlockCourses> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<IBlockCourses> bean = AutoBeanCodex.decode(factory,
															IBlockCourses.class,
															"{\"courses\" : " + json + "}");
		observer.update(new BlockCourses(bean.as()));
	}

}
