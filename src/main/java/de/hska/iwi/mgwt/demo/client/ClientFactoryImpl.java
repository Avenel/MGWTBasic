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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.mgwt.dom.client.event.touch.TouchCancelEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchHandler;
import com.googlecode.mgwt.dom.client.event.touch.TouchMoveEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchStartEvent;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.TabBarCss;
import com.googlecode.mgwt.ui.client.widget.tabbar.FavoritesTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.MostViewedTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;

import de.hska.iwi.mgwt.demo.client.activities.HomePlace;
import de.hska.iwi.mgwt.demo.client.activities.HomeView;
import de.hska.iwi.mgwt.demo.client.activities.HomeViewImpl;

/**
 * @author Daniel Kurka
 * 
 */
public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;
	private HomeViewImpl homeView;
	private RootTabPanel rootTabPanel;
	private AnimatableDisplay display;
	private PhoneActivityMapper appActivityMapper;
	private PhoneAnimationMapper appAnimationMapper;
	private AnimatingActivityManager activityManager;
	
	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		this.display = GWT.create(AnimatableDisplay.class);
		this.placeController = new PlaceController(eventBus);	
		this.appActivityMapper = new PhoneActivityMapper(this);
		this.appAnimationMapper = new PhoneAnimationMapper();
		this.activityManager = new AnimatingActivityManager(
				appActivityMapper, appAnimationMapper, this.eventBus);
		this.activityManager.setDisplay(this.display);
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public HomeView getHomeView() {
		if (this.homeView == null) {
			this.homeView = new HomeViewImpl();
			this.homeView.addContentToRootTabPanel(this.rootTabPanel);
		}

		return this.homeView;
	}

	@Override
	public RootTabPanel getRootTabPanel() {
		if (this.rootTabPanel == null) {
			TabBarCss tabBarCss = MGWTStyle.getTheme().getMGWTClientBundle()
					.getTabBarCss();
			this.rootTabPanel = new RootTabPanel(tabBarCss, this.display);
			this.rootTabPanel.setDisplayTabBarOnTop(false);

			TabBarButton tabBarButtonAktuelles = new MostViewedTabBarButton();
			TabBarButton tabBarButtonStudent = new FavoritesTabBarButton();
			TabBarButton tabBarButtonVorlesung = new HistoryTabBarButton();
			
			this.rootTabPanel.add(tabBarButtonAktuelles);
			this.rootTabPanel.add(tabBarButtonStudent);
			this.rootTabPanel.add(tabBarButtonVorlesung);

			this.rootTabPanel
					.addSelectionHandler(new SelectionHandler<Integer>() {
						@Override
						public void onSelection(SelectionEvent<Integer> event) {
							Place newPlace;
							switch (event.getSelectedItem()) {
							case 0:
								newPlace = new HomePlace();
								break;
							case 1:
								newPlace = new HomePlace();
								break;
							case 2:
								newPlace = new HomePlace();
								break;
							default:
								newPlace = null;
								break;
							}
							if (newPlace != null) {
								activityManager.onPlaceChange(new PlaceChangeEvent(newPlace));
							}
						}
					});

			this.rootTabPanel.setSelectedChild(0);
		}

		return this.rootTabPanel;
	}

	@Override
	public AnimatableDisplay getDisplay() {
		return this.display;
	}

}
