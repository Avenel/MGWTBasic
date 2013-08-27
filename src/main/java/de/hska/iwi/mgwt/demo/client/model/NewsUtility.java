package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class NewsUtility {

	private static List<News> newsList;
	private static HashMap<String, News> newsMap;
	
	public static List<News> getSortedNewsList() {
		init();
		return newsList;
	}
	
	public static News getNewsById(String id) {
		init();	
		return newsMap.get(id);
	}
	
	
	/**
	 * Initialize fixtures, dummy content
	 */
	private static void init() {
		if (newsList == null) {
			newsList = new ArrayList<News>();
			
			News n = new News();
			n.setId("1");
			n.setTitle("Neuer Koch");
			n.setContent("insert content here");
			n.setOrganisation("[Mensa]");
			n.setDate(new Date());
			newsList.add(n);
			
			n = new News();
			n.setId("2");
			n.setTitle("Ehrung Thilo Enters");
			n.setContent("insert content here");
			n.setOrganisation("[IWI]");
			n.setDate(new Date());
			newsList.add(n);
			
			n = new News();
			n.setId("3");
			n.setTitle("Kanzlerin wird 50");
			n.setContent("insert content here");
			n.setOrganisation("[R]");
			n.setDate(new Date());
			newsList.add(n);
			
			n = new News();
			n.setId("4");
			n.setTitle("Werden wir alle duemmer?");
			n.setContent("insert content here");
			n.setOrganisation("[IWI]");
			n.setDate(new Date());
			newsList.add(n);
			
			n = new News();
			n.setId("5");
			n.setTitle("Reinigungspersonal vermisst Tasche");
			n.setContent("insert content here");
			n.setOrganisation("[Mensa]");
			n.setDate(new Date());
			newsList.add(n);
		}
		
		newsMap = new HashMap<String, News>();
		
		for(News n : newsList) {
			newsMap.put(n.getId(), n);
		}
	}
	
}
