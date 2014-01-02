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

import java.util.List;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;

import de.hska.iwi.mgwt.demo.client.activities.home.HomeView;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureView;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsSettingsView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsView;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailView;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentView;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarView;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.RegisterSeminarView;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

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
	 * Get NewsSettingsView
	 * @return NewsSettingsView
	 */
	public NewsSettingsView getNewsSettingsView();
	
	/**
	 * Get ProcessSeminarView.
	 * @return ProcessSeminarView
	 */
	public ProcessSeminarView getProcessSeminarView();
	
	/**
	 * Get MensaView.
	 * @return MensaView
	 */
	public MensaView getMensaView();
	
	/**
	 * Get ProcessDetailSeminarView.
	 * @return ProcessDetailSeminarView
	 */
	public ProcessDetailView getProcessDetailView(int activeStep,List<ProcessStep> steps, int id);
	
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
