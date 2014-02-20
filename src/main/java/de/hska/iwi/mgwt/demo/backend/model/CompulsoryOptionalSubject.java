package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ICompulsoryOptionalSubject;

/**
 * Model class for a CompulsoryOptionalSUbject, holds the provided data.
 * @author Nico
 *
 */
public class CompulsoryOptionalSubject implements ICompulsoryOptionalSubject {

	private int id;
	private int contactHours;
	
	private String exam;
	private String internalName;
	private String lectureName;
	private String lecturerName;	
	
	/**
	 * C'tor which creates a deep copy of the given Interface implementation.
	 * @param iSubject the given Interface type
	 */
	public CompulsoryOptionalSubject(ICompulsoryOptionalSubject iSubject) {
		this.id = iSubject.getId();
		this.contactHours = iSubject.getContactHours();
		this.exam = iSubject.getExam();
		this.internalName = iSubject.getInternalName();
		this.lectureName = iSubject.getLectureName();
		this.lecturerName = iSubject.getLecturerName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getContactHours() {
		return contactHours;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getExam() {
		return exam;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInternalName() {
		return internalName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLectureName() {
		return lectureName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLecturerName() {
		return lecturerName;
	}
	
	/**
	 * Splits the lecturere names by each value, normally it is one long string, seperated by commas.
	 * @return a list where each entry is a lecturer.
	 */
	public List<String> getLecturerNameSeperated() {
		ArrayList<String> list = new ArrayList<String>();
		for (String s : this.lecturerName.split(",")) {
			list.add(s);
		}
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContactHours(int contactHours) {
		this.contactHours = contactHours;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setExam(String exam) {
		this.exam = exam;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	
}
