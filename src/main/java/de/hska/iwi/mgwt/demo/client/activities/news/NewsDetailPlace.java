package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Place for NewsDetail
 * @author Martin
 *
 */
public class NewsDetailPlace extends Place {
	
	private final String id;
	
	/**
	 * Public constructor, setting up NewsDetail ID (=itemID).
	 * @param id
	 */
	public NewsDetailPlace(String id) {
		this.id = id;
	}
	
	/**
	 * Getter for id.
	 * @return String id
	 */
	public String getId() {
		return this.id;
	}
	
	/** 
	 * Tokenizer class for NewsDetailPlace.
	 * @author Martin
	 *
	 */
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
