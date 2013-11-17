package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;

import de.hska.iwi.mgwt.demo.events.PageName;

/**
 * Represents a tile. It has a front- and backside.
 * On the front it has an icon and a title + information.
 * On the back it has more detailed information.
 * It flips after some time...
 * 
 * @author Martin
 *
 */
public class Tile implements IsWidget, ObserverWidget {
	
	FocusPanel focusPanel;
	
	LayoutPanel frontPanel;
	LayoutPanel backPanel;
	
	LayoutPanel currentPanel;
	
	String iconURL;
	String title;
	String color;
	
	Label updateBubble;
	
	// defines which page is behind this tile
	PageName pageName;

	AnimationHelper animationHelper;
	
	Timer flipTimer;
	int flipTime;

	
	/**
	 * Public constructor.
	 * @param frontPanel
	 * @param iconURL
	 * @param title
	 * @param color
	 */
	public Tile(String iconURL, String title, PageName pageName) {
		super();
		this.iconURL = iconURL;
		this.title = title;
		this.pageName = pageName;
		
		// official HS Karlsruhe color
		this.color = "#DB0134";
		
		this.flipTimer = new Timer() {
			@Override
			public void run() {
				flipWidget();
			}
		};
		
		this.flipTime = (int) (Math.random() * 5000.0) + 5000;
		this.flipTimer.schedule(this.flipTime);
	}


	@Override
	public Widget asWidget() {
		
		// WRAPPER
		// used to make tile touchable
		this.focusPanel = new FocusPanel(); 
		
		animationHelper = new AnimationHelper();

		// set size
		this.focusPanel.setWidth("100px");
		this.focusPanel.setHeight("100px");
		this.focusPanel.getElement().getStyle().setMarginTop(10, Unit.PX);
		
		// FRONT
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
		
		// add icon
		Image icon = new Image(this.iconURL);
		icon.setWidth("50px");
		
		icon.getElement().getStyle().setMarginLeft(15, Unit.PX);
		icon.getElement().getStyle().setMarginRight(15, Unit.PX);
		icon.getElement().getStyle().setMarginTop(5, Unit.PX);
		
		this.frontPanel.add(icon);
		
		// adding titlebox
		Label titleBox = new Label();
		titleBox.setText(this.title);
		titleBox.setWidth("70px");
		
		// font style
		titleBox.getElement().getStyle().setFontSize(12, Unit.PX);
		titleBox.getElement().getStyle().setProperty("fontFamily", "HelveticaNeue, consolas");
		titleBox.getElement().getStyle().setColor("#FFFFFF");
		
		// setup margin titlebox
		titleBox.getElement().getStyle().setMarginLeft(5, Unit.PX);
		titleBox.getElement().getStyle().setMarginRight(5, Unit.PX);
		titleBox.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		
		this.frontPanel.add(titleBox);
		
		// add updateBubble
		updateBubble = new Label();
		updateBubble.getElement().getStyle().setFontSize(12, Unit.PX);
		updateBubble.getElement().getStyle().setProperty("fontFamily", "HelveticaNeue, consolas");
		updateBubble.getElement().getStyle().setColor("#DB0134");
		updateBubble.getElement().getStyle().setWidth(20, Unit.PX);
		updateBubble.getElement().getStyle().setHeight(20, Unit.PX);
		
		updateBubble.getElement().getStyle().setProperty("top", "5px");
		updateBubble.getElement().getStyle().setProperty("right", "15px");
		updateBubble.getElement().getStyle().setProperty("position", "absolute");
		updateBubble.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		updateBubble.getElement().getStyle().setLineHeight(20, Unit.PX);
		
		updateBubble.getElement().getStyle().setBorderWidth(1, Unit.PX);
		updateBubble.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		updateBubble.getElement().getStyle().setProperty("borderRadius", "20px");
		
		updateBubble.getElement().getStyle().setBackgroundColor("#FEFEFE");
		
		updateBubble.setText("2");
		
		this.frontPanel.add(updateBubble);
		
		// BACK
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
		
		
		// init focus panel
		this.focusPanel.add(animationHelper);
		animationHelper.goTo(this.frontPanel, null);
		this.currentPanel = this.frontPanel;
		
		return this.focusPanel;
	}
	
	/**
	 * Setup tap handler for user interactions.
	 * @param handler
	 */
	public void addTapHandler(ClickHandler handler) {
		this.focusPanel.addClickHandler(handler);
	}

	
	

	/**
	 * Flips tile.
	 */
	public void flipWidget() {
		if (this.currentPanel == this.frontPanel) {
			this.currentPanel = this.backPanel;
		} else {
			this.currentPanel = this.frontPanel;
		}
		
		this.animationHelper.goTo(this.currentPanel, Animation.FLIP);
		this.flipTimer.schedule(this.flipTime);
	}
	
	public PageName getPageName() {
		return pageName;
	}


	public void setPageName(PageName pageName) {
		this.pageName = pageName;
	}


	public FocusPanel getFocusPanel() {
		return focusPanel;
	}


	public void setFocusPanel(FocusPanel focusPanel) {
		this.focusPanel = focusPanel;
	}


	public AnimationHelper getAnimationHelper() {
		return animationHelper;
	}


	public void setAnimationHelper(AnimationHelper animationHelper) {
		this.animationHelper = animationHelper;
	}


	public LayoutPanel getFrontPanel() {
		return frontPanel;
	}


	public void setFrontPanel(LayoutPanel frontPanel) {
		this.frontPanel = frontPanel;
	}


	public LayoutPanel getBackPanel() {
		return backPanel;
	}


	public void setBackPanel(LayoutPanel backPanel) {
		this.backPanel = backPanel;
	}


	/**
	 * Update tile. Update BackTile and/or "update bubble".
	 */
	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}

}
