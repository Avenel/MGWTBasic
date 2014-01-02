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

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;

import de.hska.iwi.mgwt.demo.client.activities.home.HomeView;
import de.hska.iwi.mgwt.demo.client.activities.home.HomeViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureView;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaView;
import de.hska.iwi.mgwt.demo.client.activities.mensa.MensaViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsDetailViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsSettingsView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsSettingsViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsView;
import de.hska.iwi.mgwt.demo.client.activities.news.NewsViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailView;
import de.hska.iwi.mgwt.demo.client.activities.processes.ProcessDetailViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentView;
import de.hska.iwi.mgwt.demo.client.activities.processes.StudentViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarView;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarViewImpl;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.RegisterSeminarView;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.RegisterSeminarViewImpl;
import de.hska.iwi.mgwt.demo.client.model.ProcessStep;

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
	private NewsSettingsView newsSettingsView;
	private RegisterSeminarViewImpl registerSeminarView;
	private ProcessSeminarViewImpl processSeminarView;
	private ProcessDetailViewImpl processDetailSeminarView;
	private MensaViewImpl mensaView;
	private AnimatableDisplay display;
	private PhoneActivityMapper appActivityMapper;
	private PhoneAnimationMapper appAnimationMapper;
	private AnimatingActivityManager activityManager;
	
	

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
	public ProcessSeminarView getProcessSeminarView() {
		if (processSeminarView == null) {
			processSeminarView = new ProcessSeminarViewImpl();
		}

		return  processSeminarView;
	}
	
	@Override
	public ProcessDetailView getProcessDetailView(int activeStep,List<ProcessStep> steps, int id) {
		processDetailSeminarView = new ProcessDetailViewImpl(activeStep, steps, id);
		return  processDetailSeminarView;
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

	@Override
	public NewsSettingsView getNewsSettingsView() {
		if (newsSettingsView == null) {
			newsSettingsView = new NewsSettingsViewImpl();
		}
		
		return newsSettingsView;
	}

	@Override
	public MensaView getMensaView() {
		if (mensaView == null) {
			mensaView = new MensaViewImpl();
		}
		
		return mensaView;
	}

	

}
