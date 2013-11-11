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
import com.google.gwt.user.client.ui.RootPanel;
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

import de.hska.iwi.mgwt.demo.client.activities.home.HomeView;
import de.hska.iwi.mgwt.demo.client.activities.home.HomeViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureView;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.student.RegisterSeminarView;
import de.hska.iwi.mgwt.demo.client.activities.student.RegisterSeminarViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentView;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentViewImpl;
import de.hska.iwi.mgwt.demo.events.ChangePage;

/**
 * Factory for EventBus, PlaceController, Views, RootTabPanel and Animateable Display.
 * @author Daniel Kurka
 * 
 */
public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;
	private HomeViewImpl homeView;
	private NewsViewImpl newsView;
	private StudentViewImpl studentView;
	private LectureViewImpl lectureView;
	private NewsDetailViewImpl newsDetailView;
	private RegisterSeminarViewImpl registerSeminarView;
	private RootTabPanel rootTabPanel;
	private AnimatableDisplay display;
	private PhoneActivityMapper appActivityMapper;
	private PhoneAnimationMapper appAnimationMapper;
	private AnimatingActivityManager activityManager;
	
	private int selectedChild = 0;
	

	/**
	 * Public constructor. Initializes eventbus, display, placeController, mapper 
	 * and the swipeEventHandler for the rootTabPanel.
	 */
	public ClientFactoryImpl() {
		this.eventBus = new SimpleEventBus();
		this.display = GWT.create(AnimatableDisplay.class);
		this.placeController = new PlaceController(eventBus);
		this.appActivityMapper = new PhoneActivityMapper(this);
		this.appAnimationMapper = new PhoneAnimationMapper();
		this.activityManager = new AnimatingActivityManager(appActivityMapper,
				appAnimationMapper, this.eventBus);
		this.activityManager.setDisplay(this.display);
		RootPanel.get().add(display);
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
		}
		
		return this.homeView;
	}

	@Override
	public NewsView getNewsView() {
		if (this.newsView == null) {
			this.newsView = new NewsViewImpl();
		}

		return this.newsView;
	}

	@Override
	public StudentView getStudentView() {
		if (this.studentView == null) {
			this.studentView = new StudentViewImpl();
		}

		return this.studentView;
	}

	@Override
	public LectureView getLectureView() {
		if (this.lectureView == null) {
			this.lectureView = new LectureViewImpl();
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
	public RegisterSeminarView getRegisterSeminarView() {
		if (registerSeminarView == null) {
			registerSeminarView = new RegisterSeminarViewImpl();
		}

		return  registerSeminarView;
	}
	

	@Override
	public AnimatableDisplay getDisplay() {
		return this.display;
	}

	@Override
	public AnimatingActivityManager getAnimatingActivityManager() {
		return this.activityManager;
	}

}
