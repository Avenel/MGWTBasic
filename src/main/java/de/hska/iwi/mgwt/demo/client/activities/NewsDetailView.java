package de.hska.iwi.mgwt.demo.client.activities;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

public interface NewsDetailView extends IsWidget {
	
	public void addContentToRootTabPanel (RootTabPanel rtp);
	public void setTitle(String title);
	public void setContent(String content);
}