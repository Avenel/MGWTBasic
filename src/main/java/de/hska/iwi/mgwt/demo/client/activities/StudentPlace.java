package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class StudentPlace extends Place {
	public static class StudentPlaceTokenizer implements PlaceTokenizer<StudentPlace> {

		@Override
		public StudentPlace getPlace(String token) {
			return new StudentPlace();
		}

		@Override
		public String getToken(StudentPlace place) {
			return "";
		}

	}
}
