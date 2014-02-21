package de.hska.iwi.mgwt.demo.client.activities.processes;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;

import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.processes.seminar.ProcessSeminarPlace;
import de.hska.iwi.mgwt.demo.client.model.MenuItem;

/**
 * Implements the StudentActivity. This is menu that the user reaches when he
 * clicks on the "Prozesse" Tile. In this activity the user can choose a process
 * to proceed with.
 * 
 * @author Simon
 * 
 */
public class StudentActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;
	private List<MenuItem> currentModel;
	private static final String SEMINAR_MENU_ID = "seminar";
	StudentView view;

	/**
	 * Constructor. Setup the activity with a {@link ClientFactory}
	 * @param clientFactory The clientFactory to set
	 */
	public StudentActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = this.clientFactory.getStudentView();

		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		//build the menu
		menuItems.add(new MenuItem("poject", "Projektarbeit", "register"));
		menuItems
				.add(new MenuItem(SEMINAR_MENU_ID, "Seminararbeit", "register"));
		menuItems.add(new MenuItem("events", "Veranstaltungen", "register"));
		menuItems.add(new MenuItem("practical", "Praxissemester", "register"));
		menuItems.add(new MenuItem("thesis", "Abschlussarbeit", "register"));

		currentModel = menuItems;
		view.render(menuItems);

		panel.setWidget(view);

		addHandlerRegistration(view.getMenuItemsListRegister()
				.addCellSelectedHandler(new CellSelectedHandler() {

					@Override
					public void onCellSelected(CellSelectedEvent event) {
						MenuItem selectedItem = currentModel.get(event
								.getIndex());
						if (selectedItem.getId().equals(SEMINAR_MENU_ID)) {
							ProcessSeminarPlace processSeminarPlace = new ProcessSeminarPlace();
							clientFactory.getPlaceController().goTo(
									processSeminarPlace);

						}

					}

				}));

		addHandlerRegistration(view.getMenuItemsListManage()
				.addCellSelectedHandler(new CellSelectedHandler() {

					@Override
					public void onCellSelected(CellSelectedEvent event) {
						MenuItem selectedItem = currentModel.get(event
								.getIndex());
						Window.alert(selectedItem.getId());
						
					}

				}));
	}

}
