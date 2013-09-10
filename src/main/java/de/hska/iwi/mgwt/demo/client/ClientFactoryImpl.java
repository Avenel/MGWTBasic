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
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEndEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEndHandler;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEvent;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.TabBarCss;
import com.googlecode.mgwt.ui.client.widget.tabbar.FavoritesTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.HistoryTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.MostViewedTabBarButton;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButton;
import com.googlecode.mgwt.ui.client.widget.touch.TouchDelegate;

import de.hska.iwi.mgwt.demo.client.activities.HomeView;
import de.hska.iwi.mgwt.demo.client.activities.HomeViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.LectureView;
import de.hska.iwi.mgwt.demo.client.activities.LectureViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.NewsDetailView;
import de.hska.iwi.mgwt.demo.client.activities.NewsDetailViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.StudentView;
import de.hska.iwi.mgwt.demo.client.activities.StudentViewImpl;
import de.hska.iwi.mgwt.demo.events.ChangePage;

/**
 * @author Daniel Kurka
 * 
 */
public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;
	private HomeViewImpl homeView;
	private StudentViewImpl studentView;
	private LectureViewImpl lectureView;
	private NewsDetailViewImpl newsDetailView;
	private RootTabPanel rootTabPanel;
	private AnimatableDisplay display;
	private PhoneActivityMapper appActivityMapper;
	private PhoneAnimationMapper appAnimationMapper;
	private AnimatingActivityManager activityManager;
	
	private int selectedChild = 0;
	

	public ClientFactoryImpl() {
		eventBus = new SimpleEventBus();
		this.display = GWT.create(AnimatableDisplay.class);
		this.placeController = new PlaceController(eventBus);
		this.appActivityMapper = new PhoneActivityMapper(this);
		this.appAnimationMapper = new PhoneAnimationMapper();
		this.activityManager = new AnimatingActivityManager(appActivityMapper,
				appAnimationMapper, this.eventBus);
		this.activityManager.setDisplay(this.display);

		TouchDelegate touchDel = new TouchDelegate(display.asWidget());

		touchDel.addSwipeEndHandler(new SwipeEndHandler() {
			@Override
			public void onSwipeEnd(SwipeEndEvent event) {
				if (event.getDirection() == SwipeEvent.DIRECTION.RIGHT_TO_LEFT) {
					selectedChild++;
					if (selectedChild == ChangePage.pageCount) selectedChild = 0;
					rootTabPanel.setSelectedChild(selectedChild);
				} else if (event.getDirection() == SwipeEvent.DIRECTION.LEFT_TO_RIGHT) {
					selectedChild--;
					if (selectedChild == -1) selectedChild = ChangePage.pageCount-1;
					rootTabPanel.setSelectedChild(selectedChild);
				} else {
					return;
				}
				
				ChangePage.changePageTo(selectedChild, activityManager, getPlaceController());
			}
		});
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
	public StudentView getStudentView() {
		if (this.studentView == null) {
			this.studentView = new StudentViewImpl();
			this.studentView.addContentToRootTabPanel(this.rootTabPanel);
		}

		return this.studentView;
	}

	@Override
	public LectureView getLectureView() {
		if (this.lectureView == null) {
			this.lectureView = new LectureViewImpl();
			this.lectureView.addContentToRootTabPanel(this.rootTabPanel);
		}

		return this.lectureView;
	}

	@Override
	public NewsDetailView getNewsDetailView() {
		if (this.newsDetailView == null) {
			this.newsDetailView = new NewsDetailViewImpl();
		}

		return this.newsDetailView;
	}
	
	@Override
	public RootTabPanel getRootTabPanel() {
		if (this.rootTabPanel == null) {
			TabBarCss tabBarCss = MGWTStyle.getTheme().getMGWTClientBundle()
					.getTabBarCss();
			this.rootTabPanel = new RootTabPanel(tabBarCss, this.display);
			this.rootTabPanel.setDisplayTabBarOnTop(false);

			TabBarButton tabBarButtonAktuelles = new MostViewedTabBarButton();
			tabBarButtonAktuelles.setText("Aktuelles");
			TabBarButton tabBarButtonStudent = new FavoritesTabBarButton();
			tabBarButtonStudent.setText("Student");
			TabBarButton tabBarButtonVorlesung = new HistoryTabBarButton();
			tabBarButtonVorlesung.setText("Vorlesung");
			
			this.rootTabPanel.add(tabBarButtonAktuelles);
			this.rootTabPanel.add(tabBarButtonStudent);
			this.rootTabPanel.add(tabBarButtonVorlesung);

			this.rootTabPanel
					.addSelectionHandler(new SelectionHandler<Integer>() {
						@Override
						public void onSelection(SelectionEvent<Integer> event) {
							ChangePage.changePageTo(event.getSelectedItem(), activityManager, getPlaceController());
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
