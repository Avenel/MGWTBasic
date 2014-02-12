package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum MensaStatus {
	
	@PropertyName("ok")
	OK,
	@PropertyName("invalid canteen id")
	INVALID_CANTEEN,
	@PropertyName("invalid request date")
	INVALID_REQUEST_DATE,
	@PropertyName("malformed request date")
	MALFORMED_REQUEST_DATE,
	@PropertyName("no mealplan available")
	NO_MEALPLAN;

}
