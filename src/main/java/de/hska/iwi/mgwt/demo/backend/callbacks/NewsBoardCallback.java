package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.constants.NewsType;
import de.hska.iwi.mgwt.demo.backend.gwt.CustomBeanFactory;
import de.hska.iwi.mgwt.demo.backend.gwt.NewsBoardJSON;
import de.hska.iwi.mgwt.demo.backend.gwt.NewsJSON;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class NewsBoardCallback extends AbstractRequestCallback<ObserverActivity<List<NewsBoard>>> {

	public NewsBoardCallback(ObserverActivity<List<NewsBoard>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		int status = response.getStatusCode();
		String test = response.getText();
		String moep = test;
		CustomBeanFactory factory = (CustomBeanFactory) GWT.create(CustomBeanFactory.class);
		
		AutoBean<NewsBoardJSON> bean = AutoBeanCodex.decode(factory, NewsBoardJSON.class, "{\"newsBoard\": " + moep + "}");
		
		NewsBoardJSON lala = bean.as();
		List<NewsJSON> ah = lala.getNewsBoard();
		
		ArrayList<NewsBoard> myNewsBoard = new ArrayList<NewsBoard>();
		NewsBoard board = null;
		
		for (NewsJSON news : ah) {
			board = new NewsBoard();
			board.setTitle(news.getTitle());
			board.setContent(news.getContent());
			board.setId(news.getId());
			board.setCourseOfStudies(news.getCourseOfStudies());
			board.setLinks(news.getLinks());
			board.setSubTitle(news.getSubTitle());		
			board.setType(news.getType());
			myNewsBoard.add(board);
		}
		
		
		observer.update(myNewsBoard);
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}


}
