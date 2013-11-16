package de.hska.iwi.mgwt.demo.events;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;

import de.hska.iwi.mgwt.demo.client.activities.home.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsPlace;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentPlace;

public class ChangePage {

	public static int pageCount = 3;
	
	public static void changePageTo(PageName selection, AnimatingActivityManager activityManager, PlaceController placeController) {
		Place newPlace;
		switch (selection) {
		case HOME:
			newPlace = new NewsPlace();
			break;
		case PROCESSES_MAIN:
			newPlace = new StudentPlace();
			break;
		case LECTURE_MAIN:
			newPlace = new LecturePlace();
			break;
		default:
			newPlace = new HomePlace();
			break;
		}
		
		if (newPlace != null) {
			placeController.goTo(newPlace);
		}
	}

}
