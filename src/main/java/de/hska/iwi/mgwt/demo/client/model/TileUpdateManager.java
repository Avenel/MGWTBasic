package de.hska.iwi.mgwt.demo.client.model;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.widget.Tile;

/**
 * Manages tile updates.
 * @author Martin
 *
 */
public class TileUpdateManager {

	/**
	 * Update a specific tile, by place, with given information.
	 * @param tilePlace
	 * @param information
	 */
	public static void updateTile(Place tilePlace, Label information) {
		// find corresponding tile (place -> tile)
		Tile correspondingTile = TileBoardManager.getTileByPlace(tilePlace);
		if (correspondingTile == null) return;
		
		// update panel
		LayoutPanel updatePanel = new LayoutPanel();
		updatePanel.getElement().getStyle().setPaddingTop(25, Unit.PX);
		updatePanel.getElement().getStyle().setProperty("display", "table-cell");
		updatePanel.getElement().getStyle().setProperty("verticalAlign", "middle");
		updatePanel.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		
		Label updateLabel = information;
		
		// font style
		updateLabel.getElement().getStyle().setFontSize(12, Unit.PX);
		updateLabel.getElement().getStyle().setProperty("fontFamily", "HelveticaNeue, consolas");
		updateLabel.getElement().getStyle().setColor("#FFFFFF");
		
		// setup margin titlebox
		updateLabel.getElement().getStyle().setMarginLeft(5, Unit.PX);
		updateLabel.getElement().getStyle().setMarginRight(5, Unit.PX);
		updateLabel.getElement().getStyle().setLineHeight(12, Unit.PX);
		
		updatePanel.add(updateLabel);
		
		// TODO: Increase a counter inside the tile class and do not set the amount of updates directly.
		correspondingTile.update(1, updatePanel);
	}
	
}
