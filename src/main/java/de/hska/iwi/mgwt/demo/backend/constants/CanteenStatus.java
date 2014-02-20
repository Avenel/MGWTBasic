package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

/**
 * Enum values for the status of a canteen. Specified in the REST-API Documentation.
 */
public enum CanteenStatus {
	
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
