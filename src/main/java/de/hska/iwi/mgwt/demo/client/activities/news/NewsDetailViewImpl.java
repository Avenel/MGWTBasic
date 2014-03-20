package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.dom.client.BaseElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

import de.hska.iwi.mgwt.demo.client.widget.HeaderBackButton;

/**
 * Implementation of the news detail view. Just a simple view, showing news title and its content.
 * @author Martin
 *
 */
public class NewsDetailViewImpl implements NewsDetailView {
	
	private LayoutPanel main;
	private String title;
	private String content;
	
	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		this.main.getElement().getStyle().setColor("#DB0134");
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("NewsDetail");
		this.main.add(headerPanel);
		
		HeaderBackButton backButton = new HeaderBackButton();
		headerPanel.setLeftWidget(backButton.asWidget());
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.getElement().getStyle().setPadding(20, Unit.PX);
		
		LayoutPanel textPanel = new LayoutPanel();
		textPanel.getElement().getStyle().setPaddingBottom(40, Unit.PX);
		
		HeadingElement title = Document.get().createHElement(1);
		title.setInnerText(this.title);
		textPanel.getElement().appendChild(title);
		
		BaseElement content = Document.get().createBaseElement();
		content.setInnerHTML(this.content);
		content.getStyle().setColor("grey");
		textPanel.getElement().appendChild(content);
		scrollPanel.add(textPanel);
		
		main.add(scrollPanel);
		
		return this.main;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}
}
