
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

import de.hska.iwi.mgwt.demo.client.activities.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.LecturePlace;
import de.hska.iwi.mgwt.demo.client.activities.StudentPlace;

/**
 * Maps Animation <-> Place 
 * @author Martin
 *
 */
public class PhoneAnimationMapper implements AnimationMapper {

	/**
	 * Maps animations between page changes. 
	 * Used animations: POP: startup
	 * 					SLIDE(_REVERSE): Place changes 
	 */
	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {
		boolean reverse = false;
		
		if (oldPlace == null || newPlace == null) return Animation.POP;
		
		if (oldPlace.getClass().equals(HomePlace.class) && 
				newPlace.getClass().equals(LecturePlace.class)) reverse = true;
		
		if (oldPlace.getClass().equals(StudentPlace.class) && 
				newPlace.getClass().equals(HomePlace.class)) reverse = true;
		
		if (oldPlace.getClass().equals(LecturePlace.class) && 
				newPlace.getClass().equals(StudentPlace.class)) reverse = true;
		
		if (reverse) return Animation.SLIDE_REVERSE;
		return Animation.SLIDE;
	}

}
