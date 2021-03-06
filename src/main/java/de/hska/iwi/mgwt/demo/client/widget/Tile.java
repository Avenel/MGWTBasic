package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.client.model.JSONToPlaceMapper;
import de.hska.iwi.mgwt.demo.client.model.PlaceJSONObject;
import de.hska.iwi.mgwt.demo.client.model.TileBoardManager;
import de.hska.iwi.mgwt.demo.client.model.TileJSONObject;

/**
 * Represents a tile. It has a front- and backside.
 * On the front it has an icon and a title + information.
 * On the back it has more detailed information.
 * It flips after some time...
 * 
 * @author Martin
 *
 */
public class Tile implements IsWidget, ObserverTile, TileJSONObject {
	
	/**
	 *  Necessary to make a tile clickable
	 */
	FocusPanel focusPanel;
	
	LayoutPanel frontPanel;
	LayoutPanel backPanel;
	
	LayoutPanel currentPanel;
	
	String fontAwesomeIconClass;
	ParagraphElement icon;
	String title;
	String color;
	Label titleBox;
	
	Label updateBubble;
	int updateCounter;
	
	Label removeBubble;
	
	boolean isFlippable;
	
	/**
	 * defines which page is behind this tile
	 */
	Place tilePlace;

	AnimationHelper animationHelper;
	
	Timer flipTimer;
	int flipTime;

	ClickHandler handler;
	
	/**
	 * is customLink (is it a default tile or not?)
	 */
	boolean isCustomLink;
	
	boolean isShakeing;

	/**
	 * Default Constructor
	 */
	public Tile() {}
	
	
	/**
	 * Public constructor.
	 * @param frontPanel
	 * @param fontAwesomeIconString
	 * @param title
	 * @param color
	 */
	public Tile(String fontAwesomeIconString, String title, Place place, boolean isCustomLink, boolean flippable) {
		super();
		this.fontAwesomeIconClass = fontAwesomeIconString;
		this.title = title;
		this.tilePlace = place;
		
		// official HS Karlsruhe color
		this.color = "#DB0134";
		
		this.isFlippable = flippable;
		
		this.isCustomLink = isCustomLink;
		createWidget();
		
		this.flipTimer = new Timer() {
			@Override
			public void run() {
				flipWidget();
			}
		};
		
		this.flipTime = (int) (Math.random() * 5000.0) + 5000;
		
		// prevent tile from flipping, if it is not meant to be.
		if (this.isFlippable) {
			this.flipTimer.schedule(this.flipTime);
		}
	}

	
	/**
	 * Create tileWidget.
	 */
	public void createWidget() {
		this.frontPanel = new LayoutPanel();
		this.backPanel = new LayoutPanel();
		this.focusPanel = new FocusPanel();
		this.animationHelper = new AnimationHelper();

		// WRAPPER
		setupWrapper();
		
		// FRONT
		createFrontPanel();
		
		// add icon
		createIcon();
		this.frontPanel.getElement().appendChild(icon);
		
		// adding titlebox
		createTitleBox();
		this.frontPanel.add(this.titleBox);
		
		// add updateBubble
		createUpdateBubble();		
		this.frontPanel.add(this.updateBubble);
		
		// add deleteBubble
		createRemoveBubble();
		this.frontPanel.add(this.removeBubble);
		
		// BACK
		createBack();
		
		// init focus panel
		this.focusPanel.add(animationHelper);
		animationHelper.goTo(this.frontPanel, null);
		this.currentPanel = this.frontPanel;
	}
	
	/**
	 * Reset WidgetState
	 */
	public void resetWidget() {
		this.focusPanel = new FocusPanel();
		this.animationHelper = new AnimationHelper();
		
		setupWrapper();
		
		this.focusPanel.add(animationHelper);
		if (this.handler != null) {
			this.focusPanel.addClickHandler(handler);
		}
		
		this.animationHelper.goTo(frontPanel, null);
		this.flipTimer.schedule(this.flipTime);
		this.currentPanel = this.frontPanel;
	}

	/**
	 * Return focusPanel.
	 */
	@Override
	public Widget asWidget() {
		// prevent tile from being hided if it is flipping during switching to homeview.
		resetWidget();
		
		return this.focusPanel;
	}


	/**
	 * Create BackPanel.
	 */
	private void createBack() {
		this.backPanel = new LayoutPanel();
		
		// set size
		this.backPanel.setWidth("80px");
		this.backPanel.setHeight("80px");
		this.backPanel.getElement().getStyle().setMarginTop(10, Unit.PX);
		
		// set background color
		this.backPanel.getElement().getStyle().setBackgroundColor(this.color);
		
		// setup border & border radius
		this.backPanel.getElement().getStyle().setBorderWidth(2, Unit.PX);
		this.backPanel.getElement().getStyle().setBorderStyle(BorderStyle.NONE);
		this.backPanel.getElement().getStyle().setProperty("borderRadius", "15px");
	}


	/**
	 * Create Wrapper: Focus Panel for touch interactions and animationHelper for
	 * the flip animations.
	 */
	private void setupWrapper() {
		// WRAPPER
		// used to make tile touchable
		this.focusPanel = new FocusPanel(); 
		
		this.animationHelper = new AnimationHelper();

		// set size
		this.focusPanel.setWidth("80px");
		this.focusPanel.setHeight("100px");
		this.focusPanel.getElement().getStyle().setMarginTop(10, Unit.PX);
		this.focusPanel.getElement().getStyle().setMarginRight(10, Unit.PX);
		this.focusPanel.getElement().getStyle().setMarginLeft(10, Unit.PX);
		this.focusPanel.getElement().getStyle().setPosition(Style.Position.RELATIVE);
	}


	/**
	 * Create FrontPanel: Icon + title
	 */
	private void createFrontPanel() {
		this.frontPanel = new LayoutPanel();
		
		this.frontPanel.setWidth("80px");
		this.frontPanel.setHeight("80px");
		this.frontPanel.getElement().getStyle().setMarginTop(10, Unit.PX);
		
		// set background color
		this.frontPanel.getElement().getStyle().setBackgroundColor(this.color);
		
		// setup border & border radius
		this.frontPanel.getElement().getStyle().setBorderWidth(2, Unit.PX);
		this.frontPanel.getElement().getStyle().setBorderStyle(BorderStyle.NONE);
		this.frontPanel.getElement().getStyle().setProperty("borderRadius", "15px");
		
	}


	/**
	 * Create icon.
	 */
	private void createIcon() {
		this.icon = Document.get().createPElement();
		this.icon.getStyle().setMarginLeft(15, Unit.PX);
		this.icon.getStyle().setMarginRight(15, Unit.PX);
		this.icon.getStyle().setMarginTop(10 , Unit.PX);
		this.icon.getStyle().setTextAlign(TextAlign.CENTER);
		this.icon.setInnerHTML("<i class='fa " + this.fontAwesomeIconClass + "'></i>");
	}


	/**
	 * Create TitleBox, beneath the tile icon.
	 */
	private void createTitleBox() {
		this.titleBox = new Label();
		this.titleBox.setText(this.title);
		this.titleBox.setWidth("70px");
		
		// font style
		this.titleBox.getElement().getStyle().setFontSize(12, Unit.PX);
		this.titleBox.getElement().getStyle().setProperty("fontFamily", "HelveticaNeue, consolas");
		this.titleBox.getElement().getStyle().setColor("#FFFFFF");		
		
		// setup margin titlebox
		this.titleBox.getElement().getStyle().setMarginLeft(5, Unit.PX);
		this.titleBox.getElement().getStyle().setMarginRight(5, Unit.PX);
		this.titleBox.getElement().getStyle().setTextAlign(TextAlign.CENTER);
	}


	/**
	 * Create updateBubble, positioned in the upper left corner.
	 */
	private void createUpdateBubble() {
		this.updateBubble = new Label();
		this.updateBubble.getElement().getStyle().setFontSize(12, Unit.PX);
		this.updateBubble.getElement().getStyle().setProperty("fontFamily", "HelveticaNeue, consolas");
		this.updateBubble.getElement().getStyle().setColor("#DB0134");
		this.updateBubble.getElement().getStyle().setWidth(20, Unit.PX);
		this.updateBubble.getElement().getStyle().setHeight(20, Unit.PX);
		
		this.updateBubble.getElement().getStyle().setProperty("top", "10px");
		this.updateBubble.getElement().getStyle().setProperty("right", "0px");
		this.updateBubble.getElement().getStyle().setProperty("position", "absolute");
		this.updateBubble.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		this.updateBubble.getElement().getStyle().setLineHeight(20, Unit.PX);
		
		this.updateBubble.getElement().getStyle().setBorderWidth(1, Unit.PX);
		this.updateBubble.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		this.updateBubble.getElement().getStyle().setProperty("borderRadius", "20px");
		
		this.updateBubble.getElement().getStyle().setBackgroundColor("#FEFEFE");
		this.updateBubble.getElement().getStyle().setDisplay(Display.NONE);
		
		this.updateCounter = 0;
		this.updateBubble.setText(String.valueOf(this.updateCounter));
	}
	
	/**
	 * Creates cross-icon to tell the user that he can delete this tile.
	 */
	private void createRemoveBubble() {
		this.removeBubble = new Label();
		this.removeBubble.getElement().getStyle().setColor("#DB0134");
		this.removeBubble.getElement().getStyle().setWidth(20, Unit.PX);
		this.removeBubble.getElement().getStyle().setHeight(20, Unit.PX);
		
		this.removeBubble.getElement().getStyle().setProperty("top", "10px");
		this.removeBubble.getElement().getStyle().setProperty("right", "0px");
		this.removeBubble.getElement().getStyle().setProperty("position", "absolute");
		this.removeBubble.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		this.removeBubble.getElement().getStyle().setLineHeight(20, Unit.PX);
		
		this.removeBubble.getElement().getStyle().setBorderWidth(1, Unit.PX);
		this.removeBubble.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		this.removeBubble.getElement().getStyle().setProperty("borderRadius", "20px");
		
		this.removeBubble.getElement().getStyle().setBackgroundColor("#FEFEFE");
		this.removeBubble.getElement().getStyle().setDisplay(Display.NONE);
		
		this.removeBubble.setText("");
		
		ParagraphElement pElement = Document.get().createPElement();
		pElement.setInnerHTML("<i class='fa fa-times' style='color: #DB0134'></i>");
		
		this.removeBubble.getElement().appendChild(pElement);
	}
	
	/**
	 * Setup tap handler for user interactions.
	 * @param handler
	 */
	public void addTapHandler(ClickHandler handler) {
		this.handler = handler;
		this.focusPanel.addClickHandler(handler);
	}
	
	/**
	 * Remove TapHandler.
	 */
	public void removeTapHandler() {
		this.handler = null;
	}
	
	/**
	 * Get TapHandler.
	 * @return
	 */
	public ClickHandler getTapHandler() {
		return this.handler;
	}
	

	/**
	 * Flips tile.
	 */
	public void flipWidget() {
		if (!this.isFlippable || TileBoardManager.isOrganizing()) return;
		
		if (this.currentPanel == this.frontPanel) {
			this.currentPanel = this.backPanel;
		} else {
			this.currentPanel = this.frontPanel;
		}
		
		this.animationHelper.goTo(this.currentPanel, Animation.FLIP);
		this.flipTimer.schedule(this.flipTime);
	}
	
	/**
	 * Update tile. Update BackTile and/or "update bubble".
	 */
	@Override
	public void update(int amountOfUpdates, LayoutPanel backPanel) {
		this.backPanel.clear();
		this.backPanel.add(backPanel);
		
		this.updateCounter = amountOfUpdates;
		this.updateBubble.setText(String.valueOf(amountOfUpdates));
		this.updateBubble.getElement().getStyle().setDisplay(Display.BLOCK);
	}
	
	/**
	 * Hide updateBubble, if user clicked on tile with updates.
	 */
	public void clearUpdateBubble() {
		this.updateCounter = 0;
		this.updateBubble.setText(String.valueOf(0));
		this.updateBubble.getElement().getStyle().setDisplay(Display.NONE);
		
		// reset backpanel
		this.createBack();
	}

	/**
	 * Getter for place this tile is pointing to. 
	 * @return Place target place
	 */
	public Place getTilePlace() {
		return tilePlace;
	}


	/**
	 * Setter for target place.
	 * @param tilePlace
	 */
	public void setTilePlace(Place tilePlace) {
		this.tilePlace = tilePlace;
	}


	@Override
	public Tile toTile(JSONValue jsonValue) {
		Tile returnTile = null;
		
		int parseObject = 0;
		try {
			String fontAwesomeIconString = jsonValue.isObject().get("fontAwesomeIconString").isString().stringValue();
			parseObject++;
			String title = jsonValue.isObject().get("title").isString().stringValue();
			parseObject++;
			Place place = JSONToPlaceMapper.toPlace(jsonValue.isObject().get("place").isObject());
			parseObject++;
			boolean isCustomLink = jsonValue.isObject().get("isCustomLink").isBoolean().booleanValue();
			parseObject++;
			boolean isFlippable = jsonValue.isObject().get("isFlippable").isBoolean().booleanValue();
			returnTile = new Tile(fontAwesomeIconString, title, place, isCustomLink, isFlippable);
		} catch (NullPointerException e) {
			// If any JSONValue is null -> error
			System.out.println("PARSER ERROR: " + parseObject);
			return null;
		}
		
		return returnTile;
	}


	@Override
	public JSONValue toJSON() {
		JSONValue jsonValue;
		String jsonString = new String();
		
		jsonString += "{";
		jsonString += "\"fontAwesomeIconString\": \"" + this.fontAwesomeIconClass + "\", ";
		jsonString += "\"title\": \"" + this.title + "\", ";
		jsonString += "\"place\": " + ((PlaceJSONObject) this.tilePlace).toJson() + ", ";
		jsonString += "\"isCustomLink\": " + ((this.isCustomLink) ? "true" : "false") + ", ";
		jsonString += "\"isFlippable\": " + ((this.isFlippable) ? "true" : "false");
		jsonString += "}";
		
		jsonValue = JSONParser.parseStrict(jsonString);
		return jsonValue;
	}

	/**
	 * Getter for isCustom link (is it a default tile or not?)
	 * @return Boolean isCustomLink
	 */
	public boolean isCustomLink() {
		return isCustomLink;
	}

	
	/**
	 * Setter for custom link.
	 * @param isCustomLink
	 */
	public void setCustomLink(boolean isCustomLink) {
		this.isCustomLink = isCustomLink;
	}

	/**
	 * Let the tile shake or stop shakeing.
	 * @param doShake
	 */
	public void switchShake(boolean doShake) {
		this.isShakeing = doShake;
		
		if (this.isShakeing) {
			this.focusPanel.getElement().addClassName("shake");
			if (this.isCustomLink) {
				this.removeBubble.getElement().getStyle().setDisplay(Display.BLOCK);
			}
		} else {
			this.focusPanel.getElement().removeClassName("shake");
			this.removeBubble.getElement().getStyle().setDisplay(Display.NONE);
		}
	}

	/**
	 * Flips the tile back to front panel.
	 */
	public void flipToFront() {
		if (this.currentPanel == this.backPanel) { 
			this.animationHelper.goTo(frontPanel, Animation.FLIP);
		}
	}
	
}
