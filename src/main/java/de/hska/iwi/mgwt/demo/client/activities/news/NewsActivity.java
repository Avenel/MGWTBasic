package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.model.News;
import de.hska.iwi.mgwt.demo.client.model.NewsUtility;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class NewsActivity extends MGWTAbstractActivity implements ObserverActivity {

	private final ClientFactory clientFactory;

	private List<News> currentModel;
	private List<News> unfilteredList;
	
	private NewsView view;

	public NewsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getNewsView();
		
		System.out.println("Start NewsActivity");
		
		NewsUtility.subscribe(this);
		this.unfilteredList = NewsUtility.getSortedNewsList(); 
		this.setCurrentModel(filterNews(this.unfilteredList));

		view.render(currentModel);
		panel.setWidget(view);
		
		// Celllist Touch Handler
		addHandlerRegistration(view.getListNews().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				News selectedNews = currentModel.get(event.getIndex());
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(selectedNews.getId());
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

	public List<News> getCurrentModel() {
		return currentModel;
	}

	public void setCurrentModel(List<News> currentModel) {
		this.currentModel = currentModel;
	}

	@Override
	public void update(Object arg) {
		this.unfilteredList = (List<News>) arg;
		this.setCurrentModel(filterNews(this.unfilteredList));
		view.render(currentModel);
	}

	
	/**
	 * WIP: Filters news items.
	 * @param unfiltered
	 * @return List<News> filtered News items
	 */
	public List<News> filterNews(List<News> unfiltered) {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		List<News> filteredNews = new ArrayList<News>();
		
		for (News news : unfiltered) {
			// IWI
			if (news.getOrganisation().compareTo("[IWI]") == 0 && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIWI.toString()))) {
				filteredNews.add(news);
			}
			
			// IM
			if (news.getOrganisation().compareTo("[IM]") == 0 && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIM.toString()))) {
				filteredNews.add(news);
			}
			
			// IB
			if (news.getOrganisation().compareTo("[IB]") == 0 && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIB.toString()))) {
				filteredNews.add(news);
			}
			
			// MKI
			if (news.getOrganisation().compareTo("[MKI]") == 0 && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterMKI.toString()))) {
				filteredNews.add(news);
			}
						
		}
		
		return filteredNews;
	}
	
}
