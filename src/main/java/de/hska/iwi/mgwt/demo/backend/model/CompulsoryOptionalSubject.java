package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ICompulsoryOptionalSubject;

public class CompulsoryOptionalSubject implements ICompulsoryOptionalSubject {

	private int id;
	private int contactHours;
	
	private String exam;
	private String internalName;
	private String lectureName;
	private String lecturerName;	
	
	public CompulsoryOptionalSubject(ICompulsoryOptionalSubject iSubject) {
		this.id = iSubject.getId();
		this.contactHours = iSubject.getContactHours();
		this.exam = iSubject.getExam();
		this.internalName = iSubject.getInternalName();
		this.lectureName = iSubject.getLectureName();
		this.lecturerName = iSubject.getLecturerName();
	}

	/**
	 * @return the id
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * @return the contactHours
	 */
	@Override
	public int getContactHours() {
		return contactHours;
	}

	/**
	 * @return the exam
	 */
	@Override
	public String getExam() {
		return exam;
	}

	/**
	 * @return the internalName
	 */
	@Override
	public String getInternalName() {
		return internalName;
	}

	/**
	 * @return the lectureName
	 */
	@Override
	public String getLectureName() {
		return lectureName;
	}

	/**
	 * @return the lecturerName
	 */
	@Override
	public String getLecturerName() {
		return lecturerName;
	}
	
	public List<String> getLecturerNameSeperated() {
		ArrayList<String> list = new ArrayList<String>();
		for (String s : this.lecturerName.split(",")) {
			list.add(s);
		}
		return list;
	}

	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param contactHours the contactHours to set
	 */
	@Override
	public void setContactHours(int contactHours) {
		this.contactHours = contactHours;
	}

	/**
	 * @param exam the exam to set
	 */
	@Override
	public void setExam(String exam) {
		this.exam = exam;
	}

	/**
	 * @param internalName the internalName to set
	 */
	@Override
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	/**
	 * @param lectureName the lectureName to set
	 */
	@Override
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	/**
	 * @param lecturerName the lecturerName to set
	 */
	@Override
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	
}
