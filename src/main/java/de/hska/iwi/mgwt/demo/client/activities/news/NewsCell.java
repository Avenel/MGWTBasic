package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

import de.hska.iwi.mgwt.demo.backend.model.NewsBoard;

public class NewsCell implements Cell<NewsBoard> {

	private static Template TEMPLATE = GWT.create(Template.class);
	
	public interface Template extends SafeHtmlTemplates {
//		@SafeHtmlTemplates.Template("<div style='float:left'><b>{0}</b></div><div style='float:right'><i>{1}</i></div>")
		@SafeHtmlTemplates.Template("<div style='float:left'><i class='fa {0} fa-lg' style='margin-right: 15px'></i><b>{1}</b></div><div style='float:right'><i class='fa fa-chevron-right fa-lg'></i></div>")
		SafeHtml content(String fontAwesomeIcon, String cellContents);
	}
		
	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, NewsBoard model) {
//		DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM");
		
		if (model.getType() != null) {
			SafeHtml content = TEMPLATE.content(model.getType().getFontAwesome(), model.getTitle());
			safeHtmlBuilder.append(content);
		}
	}

	@Override
	public boolean canBeSelected(NewsBoard model) {
		return true;
	}
		
}
