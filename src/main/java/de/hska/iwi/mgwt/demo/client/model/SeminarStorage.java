package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

public class SeminarStorage {
	private static List<Seminar> seminarList= new ArrayList<Seminar>();
	private static Seminar dummySeminar= new Seminar();
	
	
	public static void addSeminar(Seminar seminar){
		seminarList.add(seminar);
		
	}
	
	public static List<Seminar> getSeminarList(){
		dummySeminar.setStatus(1);
		dummySeminar.setProfessor("Prof. Dr. Ditzinger");
		dummySeminar.setTopic("Stromspartechniken: ARM");
		dummySeminar.setTerm("WS 13/14");
		
		if(!seminarList.contains(dummySeminar))
			seminarList.add(dummySeminar);
		return seminarList;
	}
}
