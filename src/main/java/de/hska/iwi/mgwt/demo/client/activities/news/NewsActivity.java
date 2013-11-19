package de.hska.iwi.mgwt.demo.client.activities.news;

import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
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
	private int startIndexIB = 0;
	private int startIndexIWI = 0;

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
		
		addHandlerRegistration(view.getListFAK().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				News selectedNews = currentModel.get(event.getIndex());
				Window.alert(selectedNews.getTitle());
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(selectedNews.getId());
				clientFactory.getPlaceController().goTo(newsDetailPlace);
			}

		}));

		// IM Handler
		addHandlerRegistration(view.getListIM().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				News selectedNews = currentModel.get(event.getIndex());
				Window.alert(selectedNews.getTitle());
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(selectedNews.getId());
				clientFactory.getPlaceController().goTo(newsDetailPlace);
			}

		}));

		// IB Handler
		addHandlerRegistration(view.getListIB().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				News selectedNews = currentModel.get(event.getIndex() + startIndexIB - 1);
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(selectedNews.getId());
				clientFactory.getPlaceController().goTo(newsDetailPlace);
			}

		}));

		// IM Handler
		addHandlerRegistration(view.getListIWI().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				News selectedNews = currentModel.get(event.getIndex() + startIndexIWI - 1);
				NewsDetailPlace newsDetailPlace = new NewsDetailPlace(selectedNews.getId());
				clientFactory.getPlaceController().goTo(newsDetailPlace);
			}

		}));
	}

	public List<News> getCurrentModel() {
		return currentModel;
	}

	public void setCurrentModel(List<News> currentModel) {
		this.currentModel = currentModel;

		int i = 1;
		for (News news : currentModel) {
			if (this.startIndexIB != 0 && this.startIndexIWI != 0) {
				break;
			}

			if (news.getOrganisation().equals("[IB]") && this.startIndexIB == 0) {
				this.startIndexIB = i;
			}

			if (news.getOrganisation().equals("[IWI]") && this.startIndexIWI == 0) {
				this.startIndexIWI = i;
			}

			i++;
		}

		System.out.println("currentModelSize: " + currentModel.size());
		System.out.println("startIndexIB: " + this.startIndexIB);
		System.out.println("startIndexIWI: " + this.startIndexIWI);
	}

	@Override
	public void update(Object arg) {
		this.setCurrentModel((List<News>) arg);
		view.render(currentModel);
	}

}
