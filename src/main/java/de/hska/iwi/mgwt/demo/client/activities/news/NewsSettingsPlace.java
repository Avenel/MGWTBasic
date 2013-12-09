package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class NewsSettingsPlace extends Place {

	public static class NewsSettingsPlaceTokenizer implements PlaceTokenizer<NewsSettingsPlace> {

		@Override
		public NewsSettingsPlace getPlace(String token) {
			return new NewsSettingsPlace();
		}

		@Override
		public String getToken(NewsSettingsPlace place) {
			return "";
		}
	
	}

}
