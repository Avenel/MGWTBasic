package de.hska.iwi.mgwt.demo.backend.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;
import de.hska.iwi.mgwt.demo.backend.constants.Weekday;
import de.hska.iwi.mgwt.demo.backend.model.CompulsoryOptionalSubjects;
import de.hska.iwi.mgwt.demo.backend.model.ConsultationHour;
import de.hska.iwi.mgwt.demo.backend.model.CourseTutorial;
import de.hska.iwi.mgwt.demo.backend.model.Meal;
import de.hska.iwi.mgwt.demo.backend.model.MealGroup;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.backend.util.TimePeriod;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class DummyIntranetConnection implements Intranet {
	
	public DummyIntranetConnection() {
		
	}

	@Override
	public List<CourseTutorial> getTutorials(Course course) {
		ArrayList<CourseTutorial> retList = new ArrayList<CourseTutorial>();
		
		CourseTutorial t = new CourseTutorial();
		t.setId(13);
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(Course.INFORMATIK_BACHELOR);
		t.setCourseOfStudies(courses);
		t.setLectureName("Betriebssysteme");
		t.setTutorName("Daniel Bälz");
		t.setDay(Weekday.FRIDAY);
		t.setTime(new TimePeriod("08:00", "09:30"));
		t.setRoom(301);
		t.setBuilding("E");
		t.setStartDate(new Date(2013-11-22));
		retList.add(t);
		
		t = new CourseTutorial();
		t.setId(2);
		courses = new ArrayList<Course>();
		courses.add(Course.INFORMATIK_BACHELOR);
		t.setCourseOfStudies(courses);
		t.setLectureName("Informatik 1");
		t.setTutorName("Andy Perdana");
		t.setDay(Weekday.THURSDAY);
		t.setTime(new TimePeriod("14:30", "16:00"));
		t.setRoom(304);
		t.setBuilding("E");
		t.setStartDate(new Date(2013-10-17));
		retList.add(t);
		
		return retList;
	}

	@Override
	public List<NewsBoard> getNewsBoard(Course course) throws IllegalArgumentException {
		if (course == null) {
			throw new IllegalArgumentException("course must not be null");
		}
		
		ArrayList<NewsBoard> retList = new ArrayList<NewsBoard>();
		
		NewsBoard v = new NewsBoard();
		v.setId(51);
		v.setTitle("Tutorium Theoretische Info 2");
		v.setSubTitle("Ausfall");
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(Course.MEDIENINFORMATIK_BACHELOR);
		courses.add(Course.INFORMATIK_BACHELOR);
		v.setCourseOfStudies(courses);
		v.setContent("Das Tutorium am Dienstag 14:000 Uhr  fällt aus.");
		v.setLinks(null);
		v.setType(NewsType.CANCELLATION);
		retList.add(v);
		
		v = new NewsBoard();
		v.setId(50);
		v.setTitle("Technische Informatik 1 Übungen");
		v.setSubTitle("Ausfall");
		courses = new ArrayList<Course>();
		courses.add(Course.MEDIENINFORMATIK_BACHELOR);
		courses.add(Course.INFORMATIK_BACHELOR);
		v.setCourseOfStudies(courses);
		v.setContent("Die Veranstaltung am Donnerstag, dem 09.01.2014 entfällt.");
		v.setLinks(null);
		v.setType(NewsType.CANCELLATION);
		retList.add(v);
		
		v = new NewsBoard();
		v.setId(33);
		v.setTitle("Technische Informatik 1 Übungen");
		v.setSubTitle("Labortermine");
		courses = new ArrayList<Course>();
		courses.add(Course.INFORMATIK_BACHELOR);
		v.setCourseOfStudies(courses);
		v.setContent("Die normalen Übungen am 25.11.2013 und 28.11.2013 entfallen für den zweiten Labortermin im LAT.\n\nFür den Montags-Zug (B2) ist der Labortermin am selben Tag, dem 25.11.2013 von 14.00 bis 17:10 Uhr in Raum LI008 (LAT).\n\nFür den Donnerstags-Zug (B1) ist der Labortermin am Montag, den 16.12.2013 von 14.00 bis 17:10 Uhr in Raum LI008 (LAT).\n");
		v.setLinks(null);
		v.setType(NewsType.ANNOUNCEMENT);
		retList.add(v);
		
		v = new NewsBoard();
		v.setId(33);
		v.setTitle("Seminar SS 2014");
		v.setSubTitle("Wichtige Änderung - Neue Voraussetzung");
		courses = new ArrayList<Course>();
		courses.add(Course.INFORMATIK_BACHELOR);
		courses.add(Course.MEDIENINFORMATIK_BACHELOR);
		v.setCourseOfStudies(courses);
		v.setContent("Ab dem Sommersemester 2014 ist das Bestehen der Veranstaltung \"Wissenschaftliches Schreiben\" Voraussetzung für den Besuch des Seminars. ");
		v.setLinks(null);
		v.setType(NewsType.ANNOUNCEMENT);
		retList.add(v);
		return retList;
	}

	@Override
	public List<ConsultationHour> getConsultationHours() {
		ArrayList<ConsultationHour> retList = new ArrayList<ConsultationHour>();
		ConsultationHour c = new ConsultationHour();
		c.setFirstname("Rolf");
		c.setLastname("Betz");
		c.setTitle("Dipl.-Inform. (FH)");
		c.setAdsAccount("bero0001");
		c.setMailAddress("bero0001@hs-karlsruhe.de");
		c.setConsultationDay(Weekday.NONE);
		c.setConsultationTime(new TimePeriod("00:00", "00:00"));
		c.setRoom("205");
		c.setBuilding("E");
		retList.add(c);
		
		c = new ConsultationHour();
		c.setFirstname("Ulrich");
		c.setLastname("Bröckl");
		c.setTitle("Prof. Dr.");
		c.setAdsAccount("brul0001");
		c.setMailAddress("brul0001@hs-karlsruhe.de");
		c.setConsultationDay(Weekday.WEDNESDAY);
		c.setConsultationTime(new TimePeriod("13:00", "14:00"));
		c.setRoom("212a");
		c.setBuilding("E");
		retList.add(c);
		
		return retList;
	}

	@Override
	public List<CompulsoryOptionalSubjects> getCompulsoryOptionalSubjects(Course course) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getTutorials(ObserverActivity<List<CourseTutorial>> observer,
			Course course) {
		observer.update(getTutorials(course));
		
	}

	@Override
	public void getNewsBoard(ObserverActivity<List<NewsBoard>> observer,
			Course course) throws IllegalArgumentException {
		observer.update(getNewsBoard(course));
		
	}

	@Override
	public void getConsultationHours(
			ObserverActivity<List<ConsultationHour>> observer) {
		observer.update(getConsultationHours());
		
	}

	@Override
	public void getCompulsoryOptionalSubjects(
			ObserverActivity<List<CompulsoryOptionalSubjects>> observer,
			Course course) throws IllegalArgumentException {
		observer.update(getCompulsoryOptionalSubjects(course));
		
	}

	@Override
	public List<MensaMenu> getMensaMenu(int id, Date date) {
		ArrayList<MensaMenu> mensaMenus = new ArrayList<MensaMenu>();
		
		MensaMenu menu = new MensaMenu();
		menu.setDate("2014-01-07");
		menu.setName("Mensa Moltkestrasse");
		menu.setStatus("ok");
		
		MealGroup mealGroup1 = new MealGroup();
		mealGroup1.setTitle("Wahlessen 1");
		
		Meal holzfaellerSteak = new Meal();
		holzfaellerSteak.setName("Holzfaellersteak vom Schweinekamm");
		holzfaellerSteak.setPriceStudent(2.10);
		holzfaellerSteak.getFoodAdditiveNumbers().add(95);
		mealGroup1.getMeals().add(holzfaellerSteak);
		
		Meal pommes = new Meal();
		pommes.setName("Pommes");
		pommes.setPriceStudent(0.90);
		pommes.getFoodAdditiveNumbers().add(97);
		mealGroup1.getMeals().add(pommes);
		
		Meal langkorn = new Meal();
		langkorn.setName("Langkornreis");
		langkorn.setPriceStudent(0.90);
		langkorn.getFoodAdditiveNumbers().add(97);
		mealGroup1.getMeals().add(langkorn);
		
		menu.getMealGroups().add(mealGroup1);
		
		MealGroup mealGroup2 = new MealGroup();
		mealGroup2.setTitle("Wahlessen 2");
		
		holzfaellerSteak = new Meal();
		holzfaellerSteak.setName("Holzfaellersteak vom Lamm");
		holzfaellerSteak.setPriceStudent(2.90);
		holzfaellerSteak.getFoodAdditiveNumbers().add(95);
		mealGroup2.getMeals().add(holzfaellerSteak);
		
		pommes = new Meal();
		pommes.setName("Pommes");
		pommes.setPriceStudent(0.90);
		pommes.getFoodAdditiveNumbers().add(97);
		mealGroup2.getMeals().add(pommes);
		
		langkorn = new Meal();
		langkorn.setName("Langkornreis");
		langkorn.setPriceStudent(0.90);
		langkorn.getFoodAdditiveNumbers().add(97);
		mealGroup2.getMeals().add(langkorn);
		
		menu.getMealGroups().add(mealGroup2);
		
		mensaMenus.add(menu);
		
		// add second menu for the next day.
		menu = new MensaMenu();
		menu.setDate("2014-01-08");
		menu.setName("Mensa Moltkestrasse");
		menu.setStatus("ok");
		
		menu.getMealGroups().add(mealGroup1);
		menu.getMealGroups().add(mealGroup2);
		mensaMenus.add(menu);
		
		return mensaMenus;
	}

}
