
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;

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
		
		// TODO the slide animation from settingmenue to another isn't good, because it is the same 
		// activity. 
		if (oldPlace.getClass().equals(SettingsPlace.class) && 
				newPlace.getClass().equals(SettingsPlace.class)) return Animation.SLIDE;
		
		
		if (reverse) return Animation.SLIDE_REVERSE;
		return Animation.SLIDE;
	}

}
