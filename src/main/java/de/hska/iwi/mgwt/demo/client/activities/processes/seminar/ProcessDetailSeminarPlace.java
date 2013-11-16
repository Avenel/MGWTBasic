package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessDetailSeminarPlace extends Place {
	String id;
	
	public ProcessDetailSeminarPlace(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	public static class ProcessDetailSeminarPlaceTokenizer implements PlaceTokenizer<ProcessDetailSeminarPlace> {

		@Override
		public ProcessDetailSeminarPlace getPlace(String id) {
			return new ProcessDetailSeminarPlace(id);
		}

		@Override
		public String getToken(ProcessDetailSeminarPlace place) {
			return place.getId();
		}

	}

}
