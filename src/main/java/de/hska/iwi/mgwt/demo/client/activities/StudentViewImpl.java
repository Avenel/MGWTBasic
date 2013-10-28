package de.hska.iwi.mgwt.demo.client.activities;

import java.util.List;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.googlecode.mgwt.ui.client.widget.tabbar.RootTabPanel;

import de.hska.iwi.mgwt.demo.client.model.MenuItem;

public class StudentViewImpl implements StudentView {

	private CellList<MenuItem> cellListStudentLifeMenuItems;
	private LayoutPanel main;
	
	public StudentViewImpl(){
		this.main = new LayoutPanel();

		AnimationHelper animationHelper = new AnimationHelper();
		RootPanel.get().add(animationHelper);

		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Studentenleben");
		this.main.add(headerPanel);

		
		animationHelper.goTo(main, Animation.SLIDE);
		this.cellListStudentLifeMenuItems = new CellList<MenuItem>(new MenuItemCell());
		ScrollPanel menuPanel = new ScrollPanel();
		menuPanel.add(cellListStudentLifeMenuItems);
		main.add(menuPanel);

	}

	@Override
	public Widget asWidget() {
		
		return main;

	}

	@Override
	public void render(List<MenuItem> menuItems) {

		this.cellListStudentLifeMenuItems.render(menuItems);

	}

	@Override
	public void addContentToRootTabPanel(RootTabPanel rtp) {
		rtp.getAnimatableDisplay().setFirstWidget(this.main);
	}
	
	@Override
	public HasCellSelectedHandler getMenuItemsList() {
		return this.cellListStudentLifeMenuItems;
	}


}
