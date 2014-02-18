package de.hska.iwi.mgwt.demo.backend.callbacks;

import de.hska.iwi.mgwt.demo.backend.model.BlockCourses;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class BlockCoursesCallback extends AbstractRequestCallback<ObserverActivity<BlockCourses>> {

	public BlockCoursesCallback(ObserverActivity<BlockCourses> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented");
		
	}

}
