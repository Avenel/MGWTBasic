package de.hska.iwi.mgwt.demo.backend.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Course implements IURLParameterEnum {
	INFORMATIK_BACHELOR("INFB"),
	INFORMATIK_MASTER("INFM"),
	MEDIENINFORMATIK_BACHELOR("MKIB"),
	ALL("ALL");
	
	private final String key;
	
	private Course(String key) {
		this.key = key;
	}
	
	@JsonCreator
	public static Course create(String value) {
		for (Course course : Course.values()) {
			if (course.getKey().equals(value)) {
				return course;
			}
		}
		return INFORMATIK_BACHELOR;
	}

	@Override
	public String getKey() {
		if (this.key.compareTo("ALL") == 0) return "";
		return this.key;
	}

}
