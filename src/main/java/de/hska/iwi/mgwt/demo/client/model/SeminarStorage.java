package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

public class SeminarStorage {
	private static List<Seminar> seminarList= new ArrayList<Seminar>();
	
	
	public static void addSeminar(Seminar seminar){
		seminarList.add(seminar);
		
	}
	
	public static List<Seminar> getSeminarList(){
		return seminarList;
	}
}
