package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.storage.client.Storage;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class NewsBoardUtility {

	private static List<NewsBoard> unfilteredNewsBoardItems;
	
	public static void setUnfilteredNewsBoardItems(List<NewsBoard> items) {
		unfilteredNewsBoardItems = items;
	}
	
	public static List<NewsBoard> getUnfilteredNewsBoardItems() {
		if (unfilteredNewsBoardItems == null) unfilteredNewsBoardItems = new ArrayList<NewsBoard>();
		return unfilteredNewsBoardItems;
	}
	
	public static NewsBoard getNewsBoardById(int id) {
		for (NewsBoard item : unfilteredNewsBoardItems) {
			if (item.getId() == id) return item;
		}
		
		return null;
	}
	
	/**
	 * WIP: Filters news items.
	 * @param unfiltered
	 * @return List<News> filtered News items
	 */
	public static List<NewsBoard> getFilteredNews() {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		List<NewsBoard> filteredNews = new ArrayList<NewsBoard>();
		
		for (NewsBoard news : unfilteredNewsBoardItems) {
			// IM
			if (news.getCourseOfStudies().contains(Course.INFORMATIK_MASTER) && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIM.toString()))) {
				filteredNews.add(news);
			}
			
			// IB
			if (news.getCourseOfStudies().contains(Course.INFORMATIK_BACHELOR) && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIB.toString()))) {
				filteredNews.add(news);
			}
			
			// MKI
			if (news.getCourseOfStudies().contains(Course.MEDIENINFORMATIK_BACHELOR) && 
					Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterMKI.toString()))) {
				filteredNews.add(news);
			}
						
		}
		
		// If List is empty, inform user to inspect settings
		if (filteredNews.size() == 0) {
			NewsBoard news = new NewsBoard();
			news.setId(1);
			news.setTitle("Empty List - Perhaps you might want to check your settings.");
			news.setContent("Perhaps you might want to check your settings.");
			news.setCourseOfStudies(new ArrayList<Course>());
			
			filteredNews.add(news);
		}
		
		return filteredNews;
	}
	
}
