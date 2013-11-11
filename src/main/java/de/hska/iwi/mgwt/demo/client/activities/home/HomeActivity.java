package de.hska.iwi.mgwt.demo.client.activities.home;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.lecture.LectureView;
import de.hska.iwi.mgwt.demo.events.ChangePage;

public class HomeActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;
	
	
	public HomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HomeView view = this.clientFactory.getHomeView();
		panel.setWidget(view);
		
		// adding button handlers
		view.getNewsButton().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				ChangePage.changePageTo(0, clientFactory.getAnimatingActivityManager(), clientFactory.getPlaceController());
			}
		});
		
		view.getStudentButton().addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				ChangePage.changePageTo(1, clientFactory.getAnimatingActivityManager(), clientFactory.getPlaceController());
			}
		});

		view.getLectureButton().addTapHandler(new TapHandler() {
		
			@Override
			public void onTap(TapEvent event) {
				ChangePage.changePageTo(2, clientFactory.getAnimatingActivityManager(), clientFactory.getPlaceController());
			}
		});
	}
	
}
