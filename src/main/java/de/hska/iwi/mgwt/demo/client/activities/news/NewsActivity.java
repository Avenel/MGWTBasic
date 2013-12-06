package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
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

public class NewsActivity extends MGWTAbstractActivity implements ObserverActivity {

	private final ClientFactory clientFactory;

	private List<News> currentModel;
	private NewsView view;

	public NewsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getNewsView();

		NewsUtility.subscribe(this);
		this.setCurrentModel(NewsUtility.getSortedNewsList());

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
		this.setCurrentModel((List<News>) arg);
		view.render(currentModel);
	}

}
