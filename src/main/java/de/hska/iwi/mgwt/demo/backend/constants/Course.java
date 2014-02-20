package de.hska.iwi.mgwt.demo.backend.constants;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;
/**
 * Enum values for the supported Courses of the IWI-Faculty
 * @author Nico
 *
 */
public enum Course implements IURLParameterEnum {
	@PropertyName("INFB")
	INFORMATIK_BACHELOR("INFB", 7),
	@PropertyName("INFM")
	INFORMATIK_MASTER("INFM", 3),
	@PropertyName("MKIB")
	MEDIENINFORMATIK_BACHELOR("MKIB", 7),
	ALL("ALL", 0);
	
	private final String key;
	private final int countOfSemester;
	
	private Course(String key, int countOfSemester) {
		this.key = key;
		this.countOfSemester = countOfSemester;
	}
		
	/**
	 * @return the countOfSemester
	 */
	public int getCountOfSemester() {
		return countOfSemester;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUrlKey() {
		return this.key;
	}

}
