package de.hska.iwi.mgwt.demo.backend.autobean;

import java.util.List;

/**
 * Interface type for the model class of a NewsBoard, is required for the GWT AutoBeanCreation.
 * @author Nico
 *
 */
public interface INewsBoard {

	/**
	 * @return the list of INews
	 */
	public List<INews> getNewsBoard();
	
	/**
	 * @param news the news to set
	 */
	public void setNewsBoard(List<INews> news);
}
