
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.activities.HomeActivity;
import de.hska.iwi.mgwt.demo.client.activities.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.LectureActivity;
import de.hska.iwi.mgwt.demo.client.activities.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.NewsDetailActivity;
import de.hska.iwi.mgwt.demo.client.activities.NewsDetailPlace;
import de.hska.iwi.mgwt.demo.client.activities.RegisterSeminarActivity;
import de.hska.iwi.mgwt.demo.client.activities.RegisterSeminarPlace;
import de.hska.iwi.mgwt.demo.client.activities.StudentActivity;
import de.hska.iwi.mgwt.demo.client.activities.StudentPlace;


/**
 * Maps Actity <-> Place.
 * @author Martin
 */
public class PhoneActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	/**
	 * Public constructor. Initializes clientFactory.
	 * @param clientFactory
	 */
	public PhoneActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Get the activity corresponding to the given place.
	 * @return Activity: {	HomeActivity, StudentActivity, LectureActivity, NewsDetailActivity,
	 * 						RegisterSeminarActivity}, default: HomeActivity.
	 */
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
		if (place.getClass().equals(NewsDetailPlace.class)) {
			return new NewsDetailActivity(clientFactory, ((NewsDetailPlace) place).getId());
		}
		if (place.getClass().equals(RegisterSeminarPlace.class)) {
			return new RegisterSeminarActivity(clientFactory);
		}
		
		return new HomeActivity(clientFactory);
	}
}
