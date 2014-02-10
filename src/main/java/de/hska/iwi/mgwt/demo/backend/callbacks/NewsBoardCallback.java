package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.gwt.NewsBoardJSON;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;
import de.hska.iwi.mgwt.demo.backend.model.NewsBoardList;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class NewsBoardCallback extends AbstractRequestCallback<ObserverActivity<List<NewsBoard>>> {

	public NewsBoardCallback(ObserverActivity<List<NewsBoard>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getStatusCode() == 200) {			
			AutoBean<NewsBoardJSON> bean = AutoBeanCodex.decode(factory, NewsBoardJSON.class, "{\"newsBoard\": " + response.getText() + "}");
			
			ArrayList<NewsBoard> myNewsBoard = new ArrayList<NewsBoard>();
			NewsBoardList list = (NewsBoardList) bean.as();
//			myNewsBoard = bean.as();
			
			NewsBoard board = null;
			
//			for (NewsJSON news : bean.as().getNewsBoard()) {
//				board = new NewsBoard();
//				board.setTitle(news.getTitle());
//				board.setContent(news.getContent());
//				board.setId(news.getId());				
//				board.setCourseOfStudies(news.getCourseOfStudies());
//				board.setLinks(news.getLinks());
//				board.setSubTitle(news.getSubTitle());		
//				board.setType(news.getType());
//				myNewsBoard.add(board);
//			}
			
//			observer.update(list.getNewsBoard());
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}


}
