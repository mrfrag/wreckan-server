package com.github.wreckan.admin.client.mvp;

import com.github.wreckan.server.model.AppInfo;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface IMainView extends IsWidget, LazyView {

	public interface IMainPresenter {

		void onStart();

		void createApp(String appName, String accessKey, Boolean storeReports);

	}

	HasClickHandlers getSubmitButton();

	HasText getAppName();

	HasText getAccessKey();

	HasValue<Boolean> getStoreReports();

	HasText getReportRecipients();

	HasText getEmailReportFields();

}
