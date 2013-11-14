package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

import de.hska.iwi.mgwt.demo.client.model.News;

public class NewsCell implements Cell<News> {

	private static Template TEMPLATE = GWT.create(Template.class);
	
	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div style='float:left'><b>{0}</b></div><div style='float:right'><i>{1}</i></div>")
		SafeHtml content(String cellContents, String date);
	}
	
	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, News model) {
		DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM");
		SafeHtml content = TEMPLATE.content(model.getTitle(), fmt.format(model.getDate()));
		
		safeHtmlBuilder.append(content);
	}

	@Override
	public boolean canBeSelected(News model) {
		return true;
	}
		
}
