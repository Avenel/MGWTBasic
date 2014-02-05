package de.hska.iwi.mgwt.demo.client.activities.settings;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SettingsPlace extends Place {
	public static class SettingsPlaceTokenizer implements PlaceTokenizer<SettingsPlace> {

		@Override
		public SettingsPlace getPlace(String token) {
			return new SettingsPlace();
		}

		@Override
		public String getToken(SettingsPlace place) {
			return "";
		}
	}
}
