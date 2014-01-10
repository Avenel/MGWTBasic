package de.hska.iwi.mgwt.demo.backend.gwt;

import java.util.List;

public interface NewsBoardJSON {

	public List<NewsJSON> getNewsBoard();
	
	public void setNewsBoard(List<NewsJSON> news);
}
