package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.connection.IntranetConnection;
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.model.NewsBoardUtility;

public class NewsActivity extends MGWTAbstractActivity implements ObserverActivity<List<NewsBoard>> {

	private final ClientFactory clientFactory;

	private List<NewsBoard> currentModel;
	
	private NewsView view;

	public NewsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getNewsView();

		// Get news of all courses
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		
		// TODO: Wenn nico den AsyncCall im master hat, wieder einbauen!
//		intranetConn.getNewsBoard(this, Course.ALL);
		intranetConn.getNewsBoard(this, Course.ALL);
		
		view.render(currentModel);
		panel.setWidget(view);
		
		// Celllist Touch Handler
		addHandlerRegistration(view.getListNews().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				NewsBoard selectedNews = currentModel.get(event.getIndex());
				
				// make cell inactive, if it is just the loading cell.
				if (selectedNews.getCourseOfStudies().size() == 0) return;
				
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(String.valueOf(selectedNews.getId()));
				clientFactory.getPlaceController().goTo(newsDetailPlace);
			}

		}));
		
		view.addTapHandlerToSettingsButton(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				clientFactory.getPlaceController().goTo(new NewsSettingsPlace());
			}
			
		});
	}

	public List<NewsBoard> getCurrentModel() {
		return currentModel;
	}

	public void setCurrentModel(List<NewsBoard> currentModel) {
		this.currentModel = currentModel;
	}
	
	@Override
	public void update(List<NewsBoard> arg) {
		NewsBoardUtility.setUnfilteredNewsBoardItems(arg);
		this.setCurrentModel(NewsBoardUtility.getFilteredNews());
		
		view.render(currentModel);
	}

}
