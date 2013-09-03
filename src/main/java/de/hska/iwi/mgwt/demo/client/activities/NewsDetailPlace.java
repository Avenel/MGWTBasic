package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class NewsDetailPlace extends Place {
	
	private final String id;
	
	public NewsDetailPlace(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public static class NewsDetailPlaceTokenizer implements PlaceTokenizer<NewsDetailPlace> {
		
		@Override
		public NewsDetailPlace getPlace(String token) {
			return new NewsDetailPlace(token);
		}

		@Override
		public String getToken(NewsDetailPlace place) {
			return place.getId();
		}

	}
}
