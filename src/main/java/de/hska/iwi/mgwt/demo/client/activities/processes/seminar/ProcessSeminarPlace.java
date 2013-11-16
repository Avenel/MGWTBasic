package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProcessSeminarPlace extends Place {
	public static class ProcessSeminarPlaceTokenizer implements PlaceTokenizer<ProcessSeminarPlace> {

		@Override
		public ProcessSeminarPlace getPlace(String token) {
			return new ProcessSeminarPlace();
		}

		@Override
		public String getToken(ProcessSeminarPlace place) {
			return "";
		}

	}

}
