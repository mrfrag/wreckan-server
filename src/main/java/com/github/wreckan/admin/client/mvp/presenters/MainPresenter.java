package com.github.wreckan.admin.client.mvp.presenters;

import com.github.wreckan.admin.client.WreckanEventBus;
import com.github.wreckan.admin.client.mvp.IMainView;
import com.github.wreckan.admin.client.mvp.IMainView.IMainPresenter;
import com.github.wreckan.admin.client.mvp.views.MainView;
import com.github.wreckan.admin.client.proxy.AppInfoProxy;
import com.github.wreckan.admin.client.requestfactory.AppInfoRequestContext;
import com.github.wreckan.admin.client.requestfactory.WreckanRequestFactory;
import com.github.wreckan.server.RequestFactoryService;
import com.github.wreckan.server.RequestFactoryServiceLocator;
import com.github.wreckan.server.model.AppInfo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

@Presenter(view = MainView.class)
public class MainPresenter extends LazyPresenter<IMainView, WreckanEventBus> implements IMainPresenter {

	@Override
	public void onStart() {
		eventBus.setBody(view);
	}

	@Override
	public void createApp(String appName, String accessKey, Boolean storeReports) {
		final EventBus eventBus = new SimpleEventBus();
		WreckanRequestFactory requestFactory = GWT.create(WreckanRequestFactory.class);
		requestFactory.initialize(eventBus);
		AppInfoRequestContext request = requestFactory.appInfoRequest();

		AppInfoProxy newApp = request.create(AppInfoProxy.class);
		newApp.setAppName(appName);
		newApp.setAccessKey(accessKey);
		newApp.setStoreReports(storeReports);

		request.save(newApp).fire(new Receiver<AppInfoProxy>() {
			@Override
			public void onSuccess(AppInfoProxy app) {
				System.out.println(app);
			}

			@Override
			public void onFailure(ServerFailure error) {
				super.onFailure(error);
				System.out.println(error);
			}
		});
	}

}
