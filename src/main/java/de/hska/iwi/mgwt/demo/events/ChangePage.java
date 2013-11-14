package de.hska.iwi.mgwt.demo.events;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentPlace;

public class ChangePage {

	public static int pageCount = 3;
	
	public static void changePageTo(int selection, AnimatingActivityManager activityManager, PlaceController placeController) {
		Place newPlace;
		switch (selection) {
		case 0:
			newPlace = new NewsPlace();
			break;
		case 1:
			newPlace = new StudentPlace();
			break;
		case 2:
			newPlace = new LecturePlace();
			break;
		default:
			newPlace = null;
			break;
		}
		if (newPlace != null) {
			placeController.goTo(newPlace);
		}
	}

}
