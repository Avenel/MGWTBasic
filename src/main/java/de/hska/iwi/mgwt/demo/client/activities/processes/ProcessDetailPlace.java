package de.hska.iwi.mgwt.demo.client.activities.processes;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessDetailPlace extends Place {
	String id;
	
	public ProcessDetailPlace(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	public static class ProcessDetailPlaceTokenizer implements PlaceTokenizer<ProcessDetailPlace> {

		@Override
		public ProcessDetailPlace getPlace(String id) {
			return new ProcessDetailPlace(id);
		}

		@Override
		public String getToken(ProcessDetailPlace place) {
			return place.getId();
		}

	}

}
