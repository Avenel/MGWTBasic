
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.activities.home.HomeActivity;
import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureActivity;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsActivity;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailActivity;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.student.ProcessSeminarActivity;
import de.hska.iwi.mgwt.demo.client.activities.student.ProcessSeminarPlace;
import de.hska.iwi.mgwt.demo.client.activities.student.RegisterSeminarActivity;
import de.hska.iwi.mgwt.demo.client.activities.student.RegisterSeminarPlace;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentActivity;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentPlace;


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
	 * 						ProcessSeminarActivity,RegisterSeminarActivity}, default: HomeActivity.
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place.getClass().equals(HomePlace.class)) {
			return new HomeActivity(clientFactory);
		}
		if (place.getClass().equals(NewsPlace.class)) {
			return new NewsActivity(clientFactory);
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
		if (place.getClass().equals(ProcessSeminarPlace.class)) {
			return new ProcessSeminarActivity(clientFactory);
		}
		if (place.getClass().equals(RegisterSeminarPlace.class)) {
			return new RegisterSeminarActivity(clientFactory);
		}
		
		return new NewsActivity(clientFactory);
	}
}
