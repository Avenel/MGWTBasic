package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

public interface INewsBoard {

	public List<INews> getNewsBoard();
	
	public void setNewsBoard(List<INews> news);
}
