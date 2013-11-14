package de.hska.iwi.mgwt.demo.client.activities.lecture;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LecturePlace extends Place {
	public static class LecturePlaceTokenizer implements PlaceTokenizer<LecturePlace> {

		@Override
		public LecturePlace getPlace(String token) {
			return new LecturePlace();
		}

		@Override
		public String getToken(LecturePlace place) {
			return "";
		}
	}
}
