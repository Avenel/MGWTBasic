package de.hska.iwi.mgwt.demo.client.activities.student;



import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

import de.hska.iwi.mgwt.demo.client.model.MenuItem;

public class MenuItemCell implements Cell<MenuItem> {

	private static Template TEMPLATE = GWT.create(Template.class);

	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div style='float:left'><b>{0}</b></div>")
		SafeHtml content(String cellContents);
	}

	@Override
	public boolean canBeSelected(MenuItem item) {
		return true;
	}

	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, MenuItem item) {
		SafeHtml content = TEMPLATE.content(item.getDisplayText());
		safeHtmlBuilder.append(content);

	}

	

}