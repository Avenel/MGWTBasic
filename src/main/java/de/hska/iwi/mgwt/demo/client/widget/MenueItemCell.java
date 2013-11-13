package de.hska.iwi.mgwt.demo.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

/**
 * Cell item for a menueItem.
 * @author Martin
 *
 */
public class MenueItemCell implements Cell<MenueItem> {

	private static Template TEMPLATE = GWT.create(Template.class);
	
	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div style='float:left'><img src='{0}' width='25px' height='25px'></div><p style='margin-left:35px'>{1}</p></div>")
		SafeHtml content(String iconURL, String title);
	}
	
	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, MenueItem model) {
		SafeHtml content = TEMPLATE.content(model.getIconURL(), model.getTitle());
		safeHtmlBuilder.append(content);
	}

	@Override
	public boolean canBeSelected(MenueItem model) {
		return true;
	}
}
