package de.hska.iwi.mgwt.demo.client.activities.mensa;

import java.util.Date;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
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

public class MensaActivity extends MGWTAbstractActivity implements ObserverActivity<MensaMenu> {
	
	private final ClientFactory clientFactory;
	
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
		
		panel.setWidget(view);
		
		// get meals for the next days
		Intranet intranetConn = (Intranet) BackendFactory.createIntranetInstance();
		int maxDays = 3;
		try {
			maxDays = Integer.valueOf(SettingStorage.getValue(StorageKey.MENSADAYCOUNT, false));
		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
		
		view.setMaxMenuDays(maxDays);
		
		for (int i = 0; i < maxDays; i++) {
			final Date dueDate = new Date();
			CalendarUtil.addDaysToDate(dueDate, i);
			String dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
			String weekDay = DateTimeFormat.getFormat("E").format(dueDate);
			
			// Determine if day is not a workday (Perhaps not the best way...)
			while (weekDay.contains("S")) {
				CalendarUtil.addDaysToDate(dueDate, 1);
				weekDay = DateTimeFormat.getFormat("E").format(dueDate);
				i++;
				maxDays++;
			}
			
			dueDateString = DateTimeFormat.getFormat("yyyy-MM-dd").format(dueDate);
			intranetConn.getMensaMenu(this, Canteen.MOLTKE, dueDateString);
		}
	}

	@Override
	public void update(MensaMenu arg) {
		this.clientFactory.getMensaView().setMensaMenu(arg);
	}

}
