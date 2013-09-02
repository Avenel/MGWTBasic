
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.activities.HomeActivity;
import de.hska.iwi.mgwt.demo.client.activities.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.LectureActivity;
import de.hska.iwi.mgwt.demo.client.activities.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.StudentActivity;
import de.hska.iwi.mgwt.demo.client.activities.StudentPlace;


/**
 * 
 */
public class PhoneActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public PhoneActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place.getClass().equals(HomePlace.class)) {
			return new HomeActivity(clientFactory);
		}
		if (place.getClass().equals(StudentPlace.class)) {
			return new StudentActivity(clientFactory);
		}
		if (place.getClass().equals(LecturePlace.class)) {
			return new LectureActivity(clientFactory);
		}
		
		return new HomeActivity(clientFactory);
	}
}
