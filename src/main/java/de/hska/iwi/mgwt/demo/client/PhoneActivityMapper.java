
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import de.hska.iwi.mgwt.demo.client.activities.home.HomeActivity;
import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureActivity;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaActivity;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsActivity;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailActivity;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsSettingsActivity;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsSettingsPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessDetailSeminarActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.RegisterSeminarActivity;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.RegisterSeminarPlace;


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
		if (place.getClass().equals(NewsSettingsPlace.class)) {
			return new NewsSettingsActivity(clientFactory);
		}
		if (place.getClass().equals(ProcessSeminarPlace.class)) {
			return new ProcessSeminarActivity(clientFactory);
		}
		if (place.getClass().equals(RegisterSeminarPlace.class)) {
			return new RegisterSeminarActivity(clientFactory);
		}
		if (place.getClass().equals(ProcessDetailPlace.class)) {
			return new ProcessDetailSeminarActivity(clientFactory, ((ProcessDetailPlace)place).getId());
		}
		if (place.getClass().equals(MensaPlace.class)) {
			return new MensaActivity(clientFactory);
		}
		
		return new NewsActivity(clientFactory);
	}
}
