package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.gwt.NewsBoardJSON;
import de.hska.iwi.mgwt.demo.backend.gwt.NewsJSON;

public class NewsBoardList implements NewsBoardJSON {

	private List<NewsJSON> listOfNews;
	
	@Override
	public List<NewsJSON> getNewsBoard() {
		return listOfNews;
	}

	@Override
	public void setNewsBoard(List<NewsJSON> news) {
		this.listOfNews = news;
	}


}
