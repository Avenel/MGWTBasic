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
public class Tile implements IsWidget {
	
	FocusPanel focusPanel;
	
	LayoutPanel frontPanel;
	LayoutPanel backPanel;
	
	LayoutPanel currentPanel;
	
	String iconURL;
	String title;
	String color;
	
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
		this.focusPanel.setWidth("80px");
		this.focusPanel.setHeight("80px");
		this.focusPanel.getElement().getStyle().setMargin(10, Unit.PX);
		
		// FRONT
		this.frontPanel = new LayoutPanel();
		
		this.frontPanel.setWidth("80px");
		this.frontPanel.setHeight("80px");
		
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
		
		// BACK
		this.backPanel = new LayoutPanel();
		
		// set size
		this.backPanel.setWidth("80px");
		this.backPanel.setHeight("80px");
		
		
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

}
