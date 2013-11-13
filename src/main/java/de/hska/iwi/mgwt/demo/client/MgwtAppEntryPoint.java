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
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

/**
 * Represents the entry point for mgwt. Initialize and start the
 * application.
 * @author Daniel Kurka
 * 
 */
public class MgwtAppEntryPoint implements EntryPoint {

	/**
	 * Setup ClientFactory, AppPlaceHistoryMapper and Display.
	 */
	private void start() {

		// set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());

		final ClientFactory clientFactory = new ClientFactoryImpl();

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);

		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(),
				new de.hska.iwi.mgwt.demo.client.activities.home.HomePlace());

		createPhoneDisplay(clientFactory);

		historyHandler.handleCurrentHistory();
	}

	/**
	 * Setup PhoneDisplay.
	 * @param clientFactory
	 */
	private void createPhoneDisplay(ClientFactory clientFactory) {
	}

	/**
	 * Starts the application.
	 */
	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				// TODO put in your own meaninful handler
				Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();

			}
		});

		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);

	}

}
