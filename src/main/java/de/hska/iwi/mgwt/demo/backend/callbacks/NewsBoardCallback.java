package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.INews;
import de.hska.iwi.mgwt.demo.backend.autobean.INewsBoard;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;

public class NewsBoardCallback extends AbstractRequestCallback<ObserverActivity<List<News>>> {

	public NewsBoardCallback(ObserverActivity<List<News>> observer) {
		super(observer);
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		if (response.getStatusCode() == 200) {			
			
			AutoBean<INewsBoard> bean = AutoBeanCodex.decode(factory, INewsBoard.class, "{\"newsBoard\": " + response.getText() + "}");
			
			observer.update(convertToImplementation(bean.as()));
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		// TODO Auto-generated method stub
		
	}
	
	private List<News> convertToImplementation(INewsBoard board) {
		ArrayList<News> news = new ArrayList<News>();
		for (INews currNews : board.getNewsBoard()) {
			News nNews = new News();
			nNews.setContent(currNews.getContent());
			nNews.setCourseOfStudies(currNews.getCourseOfStudies());
			nNews.setId(currNews.getId());
			nNews.setLinks(currNews.getLinks());
			nNews.setSubTitle(currNews.getSubTitle());
			nNews.setTitle(currNews.getTitle());
			nNews.setType(currNews.getType());
			news.add(nNews);
		}
		return news;
	}


}
