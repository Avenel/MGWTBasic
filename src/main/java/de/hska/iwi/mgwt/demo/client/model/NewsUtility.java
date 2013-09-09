package de.hska.iwi.mgwt.demo.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;

public class NewsUtility {

	private static List<News> newsList;
	private static HashMap<String, News> newsMap;
	private static List<Widget> subscribers;
	
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

			String url = "http://localhost:3000/news?format=json";
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET,
					URL.encode(url));

			try {
				Request request = builder.sendRequest(null,
				new RequestCallback() {
					public void onError(Request request,
							Throwable exception) {
						// Couldn't connect to server (could be timeout,
						// SOP violation, etc.)
						exception.printStackTrace();
					}

					public void onResponseReceived(Request request,
							Response response) {
						if (200 == response.getStatusCode()) {
							// Process the response in
							System.out.println(response.getText());

							JSONValue jsonValue;
							JSONArray jsonArray;

							jsonValue = JSONParser.parseStrict(response
									.getText());

							jsonArray = jsonValue.isArray();
							if (jsonArray == null) {
								Window.alert("Error parsing the JSON (isArray)");
							}
							
							jsonValue = jsonArray.get(0);
							if (jsonValue.isObject().get("id").isNumber() == null) {
								Window.alert("Error parsing the JSON (isNumber)");
							}

							for (int i=0; i < jsonArray.size(); i++) {
								News news = News.fromJson(jsonArray.get(i).isObject());
								newsList.add(news);
							}
							
							newsMap = new HashMap<String, News>();
							
							for (News n : newsList) {
								newsMap.put(n.getId(), n);
							}
							
							// Update subscribers
							for (Widget w : subscribers) {
								if (w instanceof CellList) {
									((CellList<News>) w).render(newsList);
								}
							}
							
						} else {
							// Handle the error. Can get the status text
							// from response.getStatusText()
							System.out.println("Error: :("
									+ response.getStatusCode());
						}
					}
				});
			} catch (RequestException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void subscribe(Widget w) {
		if (subscribers == null) {
			subscribers = new ArrayList<Widget>();
		}
		subscribers.add(w);
	}

}
