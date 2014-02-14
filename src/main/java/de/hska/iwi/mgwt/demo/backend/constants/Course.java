package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public enum Course implements IURLParameterEnum {
	@PropertyName("INFB")
	INFORMATIK_BACHELOR("INFB"),
	@PropertyName("INFM")
	INFORMATIK_MASTER("INFM"),
	@PropertyName("MKIB")
	MEDIENINFORMATIK_BACHELOR("MKIB"),
	ALL("ALL");
	
	private final String key;
	
	private Course(String key) {
		this.key = key;
	}
	
	@Override
	public String getUrlKey() {
		return this.key;
	}

}
