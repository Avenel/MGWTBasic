package de.hska.iwi.mgwt.demo.events;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;

import de.hska.iwi.mgwt.demo.client.activities.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.StudentPlace;

public class ChangePage {

	public static int pageCount = 3;
	
	public static void changePageTo(int selection, AnimatingActivityManager activityManager) {
		Place newPlace;
		switch (selection) {
		case 0:
			newPlace = new HomePlace();
			selection = 0;
			break;
		case 1:
			newPlace = new StudentPlace();
			selection = 1;
			break;
		case 2:
			newPlace = new LecturePlace();
			selection = 2;
			break;
		default:
			newPlace = null;
			break;
		}
		if (newPlace != null) {
			activityManager
					.onPlaceChange(new PlaceChangeEvent(
							newPlace));
		}
	}

}
