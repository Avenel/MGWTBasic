package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

public class NewsDetailViewImpl implements NewsDetailView {
	
	private LayoutPanel main;
	private String title;
	private String content;
	
	@Override
	public Widget asWidget() {
		this.main = new LayoutPanel();
		
		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("NewsDetail");
		this.main.add(headerPanel);
		
		HeadingElement title = Document.get().createHElement(1);
		title.setInnerText(this.title);
		main.getElement().appendChild(title);
		
		Text content = Document.get().createTextNode(this.content);
		main.getElement().appendChild(content);
		
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
