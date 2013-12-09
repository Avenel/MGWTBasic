package de.hska.iwi.mgwt.demo.client.activities.news;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;

import de.hska.iwi.mgwt.demo.client.ClientFactory;

public class NewsSettingsActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;
	private NewsSettingsView view;
	private Storage stockStore;

	public NewsSettingsActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.view = this.clientFactory.getNewsSettingsView();

		stockStore = Storage.getLocalStorageIfSupported();
		
		// add valueChangeHandler to filter checkboxes
		this.view.getIWIFilterCheckBox().addHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// store value in local storage
				stockStore.setItem("NewsSettingsFilterIWI", event.getValue().toString());
			}
			
		});
		
		this.view.getIMFilterCheckBox().addHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// store value in local storage
				stockStore.setItem("NewsSettingsFilterIM", event.getValue().toString());
			}
			
		});
		
		this.view.getIBFilterCheckBox().addHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// store value in local storage
				stockStore.setItem("NewsSettingsFilterIB", event.getValue().toString());
			}
			
		});
		
		this.view.getMKIFilterCheckBox().addHandler(new ValueChangeHandler<Boolean>() {

			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				// store value in local storage
				stockStore.setItem("NewsSettingsFilterMKI", event.getValue().toString());
			}
			
		});
		
		// Read values from storage to load default values.
		if (stockStore != null) {
			this.view.getIWIFilterCheckBox().setCheckBox(Boolean.parseBoolean(stockStore.getItem("NewsSettingsFilterIWI")));
			this.view.getIMFilterCheckBox().setCheckBox(Boolean.parseBoolean(stockStore.getItem("NewsSettingsFilterIM")));
			this.view.getIBFilterCheckBox().setCheckBox(Boolean.parseBoolean(stockStore.getItem("NewsSettingsFilterIB")));
			this.view.getMKIFilterCheckBox().setCheckBox(Boolean.parseBoolean(stockStore.getItem("NewsSettingsFilterMKI")));
		} else {
			Dialogs.alert("Web Storage Error", "", null);
		}

		panel.setWidget(view);
	}

}
