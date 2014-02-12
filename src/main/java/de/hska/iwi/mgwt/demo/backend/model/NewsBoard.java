package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.INews;
import de.hska.iwi.mgwt.demo.backend.autobean.INewsBoard;

public class NewsBoard implements INewsBoard {

	private List<INews> listOfNews;
	
	@Override
	public List<INews> getNewsBoard() {
		return listOfNews;
	}

	@Override
	public void setNewsBoard(List<INews> news) {
		this.listOfNews = news;
	}


}
