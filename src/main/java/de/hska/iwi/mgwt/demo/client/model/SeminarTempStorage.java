package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Non-persistent storage for faster access. 
 * This is used after the local storage was read the first time. 
 * @author Simon
 *
 */
public class SeminarTempStorage {
	private static List<Seminar> seminarList = new ArrayList<Seminar>();
	private static Seminar dummySeminar1 = new Seminar();
	private static Seminar dummySeminar2 = new Seminar();
	private static Seminar dummySeminar3 = new Seminar();

	/**
	 * Corresponding to the method of SeminarStorage {@link SeminarStorage#addSeminar}
	 * Adds a Seminar to the non-persistent storage
	 * @param seminar the Seminar to add
	 */
	public static void addSeminar(Seminar seminar){
		boolean contains=false;
		for(Seminar s: seminarList){
			if(s.getTopic().equals(seminar.getTopic())){
				contains=true;
			}
		}
		if(contains==false){	
			seminarList.add(seminar);
		}
		
	
	}
	/**
	 * Sets a list of seminars as the current list. Overwrites the old one.
	 * @param seminars The list to overwrite the old one with
	 */
	public static void setSeminars(List<Seminar> seminars) {
		seminarList = seminars;
	}
	/**
	 * Gets all Seminars currently in the non-persistent storage as a list
	 * @return the Seminars as a List
	 */
	public static List<Seminar> getSeminarList() {

		return seminarList;
	}
	
}
