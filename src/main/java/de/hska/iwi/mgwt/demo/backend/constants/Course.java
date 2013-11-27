package de.hska.iwi.mgwt.demo.backend.constants;

public enum Course {
	INFORMATIK_BACHELOR("INFB"),
	INFORMATIK_MASTER("INFM"),
	MEDIENINFORMATIK_BACHELOR("MKIB");
	
	private final String shortage;
	
	private Course(String shortage) {
		this.shortage = shortage;
	}
	
	@Override
	public String toString() {
		return this.shortage;
	}

}
