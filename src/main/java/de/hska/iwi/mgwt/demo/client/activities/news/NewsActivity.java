package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.ArrayList;
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
import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;
import de.hska.iwi.mgwt.demo.client.model.NewsBoardUtility;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Implements the news activity. 
 * @author Martin
 *
 */
public class NewsActivity extends MGWTAbstractActivity implements ObserverActivity<List<News>> {

	private final ClientFactory clientFactory;

	private List<News> currentModel;
	
	private NewsView view;

	/**
	 * Public constructor. Setup activity with ClientFactory.
	 * @param clientFactory
	 */
	public NewsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getNewsView();
		
		currentModel = new ArrayList<News>();
		view.render(currentModel);
		panel.setWidget(view);
		
		// Celllist Touch Handler
		addHandlerRegistration(view.getListNews().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				try {
					// If no filter is set, go to settings
					if (!Boolean.parseBoolean(SettingStorage.getValue(StorageKey.NewsSettingsFilterIB, false)) &&
							!Boolean.parseBoolean(SettingStorage.getValue(StorageKey.NewsSettingsFilterIM, false)) &&
							!Boolean.parseBoolean(SettingStorage.getValue(StorageKey.NewsSettingsFilterMKI, false))) {
						clientFactory.getPlaceController().goTo(new SettingsPlace(SettingMenueName.NEWS.toString()));
					} else {
						News selectedNews = currentModel.get(event.getIndex());
						
						// make cell inactive, if it is just the loading cell.
						if (selectedNews.getCourseOfStudies().size() == 0) return;
						
						NewsDetailPlace newsDetailPlace = new NewsDetailPlace(String.valueOf(selectedNews.getId()));
						clientFactory.getPlaceController().goTo(newsDetailPlace);
					}
				} catch (Exception e) {
					clientFactory.getPlaceController().goTo(new SettingsPlace(SettingMenueName.NEWS.toString()));
				}
			}
		}));
		
		view.addTapHandlerToSettingsButton(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				clientFactory.getPlaceController().goTo(new SettingsPlace(SettingMenueName.NEWS.toString()));
			}
			
		});
		
		// Get news of all courses
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		intranetConn.getNewsBoard(this, Course.ALL);
	}

	/**
	 * Setter for the currentModel = NewsItems.
	 * @param currentModel
	 */
	public void setCurrentModel(List<News> currentModel) {
		this.currentModel = currentModel;
	}
	
	@Override
	public void update(List<News> arg) {
		NewsBoardUtility.setUnfilteredNewsBoardItems(arg);
		this.setCurrentModel(NewsBoardUtility.getFilteredNews());
		
		view.render(currentModel);
		
	}

}
