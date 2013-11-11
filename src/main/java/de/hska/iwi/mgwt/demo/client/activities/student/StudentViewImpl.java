package de.hska.iwi.mgwt.demo.client.activities.student;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.model.MenuItem;

public class StudentViewImpl implements StudentView {

	private CellList<MenuItem> cellListStudentLifeMenuItemsRegister;
	private CellList<MenuItem> cellListStudentLifeMenuItemsManage;
	private LayoutPanel main;
	
	public StudentViewImpl(){
		this.main = new LayoutPanel();

		//AnimationHelper animationHelper = new AnimationHelper();
		//RootPanel.get().add(animationHelper);

		HeaderPanel headerPanel = new HeaderPanel();
		headerPanel.setCenter("Prozesse");
		this.main.add(headerPanel);
		
		this.cellListStudentLifeMenuItemsRegister = new CellList<MenuItem>(new MenuItemCell());
		ScrollPanel menuPanelRegister = new ScrollPanel();
		menuPanelRegister.add(cellListStudentLifeMenuItemsRegister);
		
		this.cellListStudentLifeMenuItemsManage = new CellList<MenuItem>(new MenuItemCell());
		ScrollPanel menuPanelManage = new ScrollPanel();
		menuPanelManage.add(cellListStudentLifeMenuItemsManage);
		
		
		
		//animationHelper.goTo(main, Animation.SLIDE);
		
		main.add(menuPanelRegister);

	}

	@Override
	public Widget asWidget() {
		
		return main;

	}

	@Override
	public void render(List<MenuItem> menuItems) {
		List<MenuItem> menuItemsRegister = new ArrayList<MenuItem>();
		List<MenuItem> menuItemsManage = new ArrayList<MenuItem>();
		
		for (MenuItem item : menuItems) {
			if (item.getType().equals("register")) {
				menuItemsRegister.add(item);
			}
			if (item.getType().equals("manage")) {
				menuItemsManage.add(item);
			}
			
		}
		
		

		this.cellListStudentLifeMenuItemsRegister.render(menuItemsRegister);
		this.cellListStudentLifeMenuItemsManage.render(menuItemsManage);
		

	}
	
	@Override
	public HasCellSelectedHandler getMenuItemsListRegister() {
		return this.cellListStudentLifeMenuItemsRegister;
	}
	@Override
	public HasCellSelectedHandler getMenuItemsListManage() {
		return this.cellListStudentLifeMenuItemsManage;
	}


}