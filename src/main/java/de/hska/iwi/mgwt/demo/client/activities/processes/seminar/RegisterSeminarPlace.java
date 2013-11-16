package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterSeminarPlace extends Place {
	public static class RegisterSeminarPlaceTokenizer implements PlaceTokenizer<RegisterSeminarPlace> {

		@Override
		public RegisterSeminarPlace getPlace(String token) {
			return new RegisterSeminarPlace();
		}

		@Override
		public String getToken(RegisterSeminarPlace place) {
			return "";
		}

	}

}
