package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.storage.client.Storage;

import de.hska.iwi.mgwt.demo.backend.constants.Course;
import de.hska.iwi.mgwt.demo.backend.constants.NewsType;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * This static helper class manage the news items, for example holding and filtering 
 * news items.
 * @author Martin
 *
 */
public class NewsBoardUtility {

	private static List<News> unfilteredNewsBoardItems;
	
	/**
	 * Setter for unfilterted news items.
	 * @param items
	 */
	public static void setUnfilteredNewsBoardItems(List<News> items) {
		unfilteredNewsBoardItems = items;
	}
	
	/**
	 * Getter for unfiltered news items.
	 * @return List<News> news item list
	 */
	public static List<News> getUnfilteredNewsBoardItems() {
		if (unfilteredNewsBoardItems == null) unfilteredNewsBoardItems = new ArrayList<News>();
		return unfilteredNewsBoardItems;
	}
	
	/**
	 * Getter for a specific news item, by id.
	 * @param id
	 * @return News item
	 */
	public static News getNewsBoardById(int id) {
		for (News item : unfilteredNewsBoardItems) {
			if (item.getId() == id) return item;
		}
		
		return null;
	}
	
	/**
	 * Filters news items.
	 * @return List<News> filtered News items
	 */
	public static List<News> getFilteredNews() {
		Storage stockStore = Storage.getLocalStorageIfSupported();
		List<News> filteredNews = new ArrayList<News>();
		
		for (News news : unfilteredNewsBoardItems) {
			// IM
			if ((news.getCourseOfStudies().contains(Course.INFORMATIK_MASTER) || news.getCourseOfStudies().contains(Course.ALL)) 
					&& Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIM.toString()))) {
				filteredNews.add(news);
				continue;
			}
			
			// IB
			if ((news.getCourseOfStudies().contains(Course.INFORMATIK_BACHELOR) || news.getCourseOfStudies().contains(Course.ALL)) 
					&& Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterIB.toString()))) {
				filteredNews.add(news);
				continue;
			}
			
			// MKI
			if ((news.getCourseOfStudies().contains(Course.MEDIENINFORMATIK_BACHELOR) || news.getCourseOfStudies().contains(Course.ALL))
					&& Boolean.parseBoolean(stockStore.getItem(StorageKey.NewsSettingsFilterMKI.toString()))) {
				filteredNews.add(news);
				continue;
			}
						
		}
		
		// add "no news items" notification
		String noItemsMessage = "Keine Nachrichten vorhanden";
		if (filteredNews.size() == 0) {
			News noItems = new News();
			try {
				if (!Boolean.valueOf(SettingStorage.getValue(StorageKey.NewsSettingsFilterIB, false)) &&
					!Boolean.valueOf(SettingStorage.getValue(StorageKey.NewsSettingsFilterIB, false)) &&
					!Boolean.valueOf(SettingStorage.getValue(StorageKey.NewsSettingsFilterIB, false))) {
					
					noItemsMessage = "Bitte wähle einen Studiengang aus.";
					
				} 
			} catch (Exception e) {
				// no filters set
				noItemsMessage = "Bitte wwähle einen Studiengang aus.";
			}
			
			noItems.setContent("Gehe in die News Einstellungen und überprüfe deine Auswahl.");
			noItems.setTitle(noItemsMessage);
			noItems.setType(NewsType.ANNOUNCEMENT);
			noItems.setId(0);
			
			filteredNews.add(noItems);
			unfilteredNewsBoardItems.add(noItems);
		}
		
		return filteredNews;
	}
	
}
