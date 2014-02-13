package de.hska.iwi.mgwt.demo.backend.model;

import java.util.ArrayList;
import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.ITutorial;
import de.hska.iwi.mgwt.demo.backend.autobean.ITutorials;

public class Tutorials {
	
	private List<CourseTutorial> tutorials;
	
	public Tutorials() {
		tutorials = new ArrayList<CourseTutorial>();
	}
	
	public Tutorials(ITutorials iTutorials) {
		tutorials = new ArrayList<CourseTutorial>();
		
		for (ITutorial tut : iTutorials.getTutorials()) {
			tutorials.add(new CourseTutorial(tut));
		}
	}

	/**
	 * @return the tutorials
	 */
	public List<CourseTutorial> getTutorials() {
		return tutorials;
	}

	/**
	 * @param tutorials the tutorials to set
	 */
	public void setTutorials(List<CourseTutorial> tutorials) {
		this.tutorials = tutorials;
	}

}
