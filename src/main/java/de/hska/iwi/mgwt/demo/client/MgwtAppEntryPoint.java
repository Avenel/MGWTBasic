/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.hska.iwi.mgwt.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.accelerometer.Acceleration;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationOptions;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTStyle;

import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.theme.CustomTheme;

/**
 * Represents the entry point for mgwt. Initialize and start the
 * application.
 * @author Daniel Kurka
 * 
 */
public class MgwtAppEntryPoint implements EntryPoint {
	
	private IFakExceptionHandler exceptionHandler;
	
	private final ClientFactory clientFactory = new ClientFactoryImpl();
	/**
	 * Setup ClientFactory, AppPlaceHistoryMapper and Display.
	 */
	private void start() {
		
		MGWTStyle.setTheme(new CustomTheme());
		
		//this will create a link element at the end of head
		MGWTStyle.getTheme().getMGWTClientBundle().getMainCss().ensureInjected();

		// append font-awesome css
		MGWTStyle.injectStyleSheet("assets/fonts/font-awesome/css/font-awesome.css");
		
		// set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());
		
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		
		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(),
				new de.hska.iwi.mgwt.demo.client.activities.home.HomePlace());
		
		// initialize TileBoard
		TileBoardManager.initTiles();
		
		historyHandler.handleCurrentHistory();
	}

	/**
	 * Starts the application.
	 */
	@Override
	public void onModuleLoad() {
		exceptionHandler = new IFakExceptionHandler(clientFactory.getPlaceController(), clientFactory);
		clientFactory.getEventBus().addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
			private final IFakExceptionHandler exHandler = exceptionHandler;
			
			@Override
			public void onPlaceChange(PlaceChangeEvent event) {
				exHandler.notifyOnPlaceChange();
				
			}
		});
		
		GWT.setUncaughtExceptionHandler(exceptionHandler);

		// init phonegap
		final PhoneGap phoneGap = GWT.create(PhoneGap.class);

	    phoneGap.addHandler(new PhoneGapAvailableHandler() {

	      @Override
	      public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
	        Window.alert("Success loading PhoneGap!!!");
	        Window.alert(phoneGap.getDevice().getPhoneGapVersion());
	        phoneGap.getAccelerometer().getCurrentAcceleration(new AccelerationCallback() {
				
				@Override
				public void onSuccess(Acceleration arg0) {
					Window.alert("AccX: " + arg0.getX() + " AccY: " + arg0.getY() + " AccZ: " + arg0.getZ());
				}
				
				@Override
				public void onFailure() {
					Window.alert("Failed getting accel");
				}
			}, new AccelerationOptions());
	      }
	    });

	    phoneGap.addHandler(new PhoneGapTimeoutHandler() {

	      @Override
	      public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
	        Window.alert("can not load phonegap");

	      }
	    });

	    phoneGap.initializePhoneGap();
		
		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);

	}

}
