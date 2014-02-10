package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

public class SeminarTempStorage {
	private static List<Seminar> seminarList = new ArrayList<Seminar>();
	private static Seminar dummySeminar1 = new Seminar();
	private static Seminar dummySeminar2 = new Seminar();
	private static Seminar dummySeminar3 = new Seminar();

	public static void addSeminar(Seminar seminar) {
		seminarList.add(seminar);

	}

	public static void setSeminars(List<Seminar> seminars) {
		seminarList = seminars;
	}

	public static List<Seminar> getSeminarList() {
		if (seminarList.isEmpty()) {
			dummySeminar1.setStatus(6);
			dummySeminar1.setProfessor("Prof. Dr. Ditzinger");
			dummySeminar1.setTopic("DUMMY: Stromspartechniken: ARM");
			dummySeminar1.setTerm("WS 13/14");

			dummySeminar2.setStatus(3);
			dummySeminar2.setProfessor("Prof. Dr. Mustermann");
			dummySeminar2.setTopic("DUMMY: Random");
			dummySeminar2.setTerm("WS 13/14");

			dummySeminar3.setStatus(1);
			dummySeminar3.setProfessor("Prof. Dr. Musterfrau");
			dummySeminar3.setTopic("DUMMY: Randoma");
			dummySeminar3.setTerm("WS 13/14");

			seminarList.add(dummySeminar1);

			seminarList.add(dummySeminar2);

			seminarList.add(dummySeminar3);
		}

		return seminarList;
	}
}
