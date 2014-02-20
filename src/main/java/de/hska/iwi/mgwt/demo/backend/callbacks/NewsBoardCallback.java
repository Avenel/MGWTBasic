package de.hska.iwi.mgwt.demo.backend.callbacks;

import java.util.ArrayList;
import java.util.List;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;

import de.hska.iwi.mgwt.demo.backend.autobean.INews;
import de.hska.iwi.mgwt.demo.backend.autobean.INewsBoard;
import de.hska.iwi.mgwt.demo.backend.model.News;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
/**
 * Responsible for creating a List of {@link News}-Model.
 * @author Nico
 *
 */
public class NewsBoardCallback extends AbstractRequestCallback<ObserverActivity<List<News>>> {

	public NewsBoardCallback(ObserverActivity<List<News>> observer) {
		super(observer);
	}

	@Override
	protected void handleJson(String json) {
		AutoBean<INewsBoard> bean = AutoBeanCodex.decode(factory, INewsBoard.class, "{\"newsBoard\": " + json + "}");
		ArrayList<News> newsList = new ArrayList<News>();
		
		for (INews currnews : bean.as().getNewsBoard()) {
			newsList.add(new News(currnews));
		}
		
		observer.update(newsList);
	}
}
