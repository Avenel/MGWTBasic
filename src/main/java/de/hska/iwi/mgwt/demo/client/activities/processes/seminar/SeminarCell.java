package de.hska.iwi.mgwt.demo.client.activities.processes.seminar;



import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;

import de.hska.iwi.mgwt.demo.client.model.Seminar;

public class SeminarCell implements Cell<Seminar> {
	public String test="";

	private static Template TEMPLATE = GWT.create(Template.class);

	public interface Template extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<div id='test'><b>{0}: </b>{1}</div><div style='float:right'><i>{2}</i></div>")
		
		SafeHtml content(String professor, String topic, int status);
	}

	@Override
	public boolean canBeSelected(Seminar seminar) {
		return true;
	}

	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, Seminar seminar) {
		SafeHtml content = TEMPLATE.content(seminar.getProfessor(), seminar.getTopic(), seminar.getStatus());
		safeHtmlBuilder.append(content);

	}
	public SeminarCell(String test){
		super();
		test=this.test;
		
	}

	

}