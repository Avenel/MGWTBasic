package de.hska.iwi.mgwt.demo.client.activities.mensa;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MensaPlace extends Place {

	public static class MensaPlaceTokenizer implements PlaceTokenizer<MensaPlace> {

		@Override
		public MensaPlace getPlace(String token) {
			return new MensaPlace();
		}

		@Override
		public String getToken(MensaPlace place) {
			return "";
		}
	}
	
}
