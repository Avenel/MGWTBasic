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

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.activities.home.HomeView;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsView;
import de.hska.iwi.mgwt.demo.client.activities.student.RegisterSeminarView;
import de.hska.iwi.mgwt.demo.client.activities.student.StudentView;

/**
 * Factory for EventBus, PlaceController, Views, RootTabPanel and Animateable Display.
 * @author Martin
 *
 */
public interface ClientFactory {

	/**
	 * Get Event Bus.
	 * @return EventBus
	 */
	public EventBus getEventBus();

	/**
	 * Get PlaceController.
	 * @return PlaceController
	 */
	public PlaceController getPlaceController();
	
	/**
	 * Get HomeView.
	 * @return HomeView
	 */
	public HomeView getHomeView();
	
	/**
	 * Get NewsView.
	 * @return NewsView
	 */
	public NewsView getNewsView();
	
	/**
	 * Get StudentView.
	 * @return StudentView
	 */
	public StudentView getStudentView();
	
	/**
	 * Get LectureView.
	 * @return LectureView
	 */
	public LectureView getLectureView();
	
	/**
	 * Get NewsDetailView.
	 * @return NewsDetailView
	 */
	public NewsDetailView getNewsDetailView();
	
	/**
	 * Get RegisterSeminarView.
	 * @return RegisterSeminarView
	 */
	public RegisterSeminarView getRegisterSeminarView();
	

	/**
	 * Get AnimateableDisplay.
	 * @return AnimateableDisplay
	 */
	public AnimatableDisplay getDisplay();
	
	/**
	 * Get AnimatingActivityManager
	 * @return AnimatingActivityManager
	 */
	public AnimatingActivityManager getAnimatingActivityManager();


}
