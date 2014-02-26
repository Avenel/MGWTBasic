package de.hska.iwi.mgwt.demo.client.activities.mensa;

import java.util.Date;

import org.apache.bcel.verifier.structurals.ExceptionHandler;
import org.apache.bcel.verifier.structurals.ExceptionHandlers;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.thirdparty.guava.common.util.concurrent.UncaughtExceptionHandlers;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

import de.hska.iwi.mgwt.demo.backend.BackendFactory;
import de.hska.iwi.mgwt.demo.backend.Intranet;
import de.hska.iwi.mgwt.demo.backend.constants.Canteen;
import de.hska.iwi.mgwt.demo.backend.model.MensaMenu;
import de.hska.iwi.mgwt.demo.client.ClientFactory;
import de.hska.iwi.mgwt.demo.client.activities.ObserverActivity;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingMenueName;
import de.hska.iwi.mgwt.demo.client.activities.settings.SettingsPlace;
import de.hska.iwi.mgwt.demo.client.storage.SettingStorage;
import de.hska.iwi.mgwt.demo.client.storage.StorageKey;

/**
 * Implements the mensa activity. Getting mensa menus for a given amount of days.
 * @author Martin
 *
 */
public class MensaActivity extends MGWTAbstractActivity implements ObserverActivity<MensaMenu> {
	
	private final ClientFactory clientFactory;
	
	/**
	 * Public constructor. Setup mensa activity with ClientFactory.
	 * @param clientFactory
	 */
	public MensaActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override 
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		MensaView view = this.clientFactory.getMensaView();
		
		view.addTapHandlerToSettingsButton(new TapHandler() {
			@Override
			public void onTap(TapEvent event) {
				clientFactory.getPlaceController().goTo(new SettingsPlace(SettingMenueName.MENSA.toString()));
			}
			
		});
		
		// get meals for the next days
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		int maxDays = 1;
		try {
			maxDays = Integer.valueOf(SettingStorage.getValue(StorageKey.MENSADAYCOUNT, false));
		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
		
		view.setMaxMenuDays(maxDays);
		
		panel.setWidget(view);
		
		Date dueDate = new Date();
		for (int i = 0; i < maxDays; i++) {
			String dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
			String weekDay = DateTimeFormat.getFormat("E").format(dueDate);
			
			// Determine if day is not a workday (Perhaps not the best way...)
			while (weekDay.contains("S")) {
				CalendarUtil.addDaysToDate(dueDate, 1);
				weekDay = DateTimeFormat.getFormat("E").format(dueDate);
			}
			
			dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
			try {
				intranetConn.getMensaMenu(this, Canteen.getCanteenByName(SettingStorage.getValue(StorageKey.MENSA, false)), dueDateString);
			} catch (IllegalArgumentException e) {
				// load by default mensa moltke
				intranetConn.getMensaMenu(this, Canteen.MOLTKE, dueDateString);
			} catch (Exception e) {
				// load by default mensa moltke
				intranetConn.getMensaMenu(this, Canteen.MOLTKE, dueDateString);
			}
			
			CalendarUtil.addDaysToDate(dueDate, 1);
		}
	}

	@Override
	public void update(MensaMenu arg) {
		// update mensa view with received data.
		this.clientFactory.getMensaView().setMensaMenu(arg);
	}

}
