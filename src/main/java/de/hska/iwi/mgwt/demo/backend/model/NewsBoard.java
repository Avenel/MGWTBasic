package de.hska.iwi.mgwt.demo.backend.model;

import java.util.List;

import de.hska.iwi.mgwt.demo.backend.autobean.INews;
import de.hska.iwi.mgwt.demo.backend.autobean.INewsBoard;
/**
 * Model which holds one or more {@link News}
 * @author Nico
 *
 */
public class NewsBoard implements INewsBoard {

	private List<INews> listOfNews;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<INews> getNewsBoard() {
		return listOfNews;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNewsBoard(List<INews> news) {
		this.listOfNews = news;
	}


}
