package de.hska.iwi.mgwt.demo.backend.autobean;

/**
 * Interface for a model type of an CompulsoryOptionalSubject. This Interface is necessary for the GWT AutoBean creation.
 * @author Nico
 *
 */
public interface ICompulsoryOptionalSubject {

	/**
	 * @return the id
	 */
	public int getId();
	/**
	 * @param id the id to set
	 */
	public void setId(int id);
	
	/**
	 * @return the contactHours
	 */
	public int getContactHours();
	/**
	 * @param contactHours the contactHours to set
	 */
	public void setContactHours(int hours);
	
	/**
	 * @return the exam
	 */
	public String getExam();
	/**
	 * @param exam the exam to set
	 */
	public void setExam(String exam);
	
	/**
	 * @return the internalName
	 */
	public String getInternalName();
	/**
	 * @param internalName the internalName to set
	 */
	public void setInternalName(String internalName);
	
	/**
	 * @return the lectureName
	 */
	public String getLectureName();
	/**
	 * @param lectureName the lectureName to set
	 */
	public void setLectureName(String lectureName);
	
	/**
	 * @return the lecturerName
	 */
	public String getLecturerName();
	/**
	 * @param lecturerName the lecturerName to set
	 */
	public void setLecturerName(String lecturereNames);
	
	
}
