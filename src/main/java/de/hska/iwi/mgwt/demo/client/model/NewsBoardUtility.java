package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.storage.client.Storage;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

public class NewsBoardUtility {

	private static List<News> unfilteredNewsBoardItems;
	
	public static void setUnfilteredNewsBoardItems(List<News> items) {
		unfilteredNewsBoardItems = items;
	}
	
	public static List<News> getUnfilteredNewsBoardItems() {
		if (unfilteredNewsBoardItems == null) unfilteredNewsBoardItems = new ArrayList<News>();
		return unfilteredNewsBoardItems;
	}
	
	public static News getNewsBoardById(int id) {
		for (News item : unfilteredNewsBoardItems) {
			if (item.getId() == id) return item;
		}
		
		return null;
	}
	
	/**
	 * WIP: Filters news items.
	 * @param unfiltered
	 * @return List<News> filtered News items
	 */
	public static List<News> getFilteredNews() {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		List<News> filteredNews = new ArrayList<News>();
		
		for (News news : unfilteredNewsBoardItems) {
			// IM
			if ((news.getCourseOfStudies().contains(Course.INFM) || news.getCourseOfStudies().contains(Course.ALL)) 
					&& Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIM.toString()))) {
				filteredNews.add(news);
				continue;
			}
			
			// IB
			if ((news.getCourseOfStudies().contains(Course.INFB) || news.getCourseOfStudies().contains(Course.ALL)) 
					&& Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIB.toString()))) {
				filteredNews.add(news);
				continue;
			}
			
			// MKI
			if ((news.getCourseOfStudies().contains(Course.MKIB) || news.getCourseOfStudies().contains(Course.ALL))
					&& Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterMKI.toString()))) {
				filteredNews.add(news);
				continue;
			}
						
		}
		
		// If List is empty, inform user to inspect settings
		if (filteredNews.size() == 0) {
			News news = new News();
			news.setId(1);
			news.setTitle("Empty List - Perhaps you might want to check your settings.");
			news.setContent("Perhaps you might want to check your settings.");
			news.setCourseOfStudies(new ArrayList<Course>());
			
			filteredNews.add(news);
		}
		
		return filteredNews;
	}
	
}
