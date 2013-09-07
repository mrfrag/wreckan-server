package com.github.wreckan.admin.client.mvp.presenters;

import com.github.wreckan.admin.client.WreckanEventBus;
import com.github.wreckan.admin.client.mvp.IRootView;
import com.github.wreckan.admin.client.mvp.IRootView.IRootPresenter;
import com.github.wreckan.admin.client.mvp.views.RootView;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = RootView.class)
public class RootPresenter extends BasePresenter<IRootView, WreckanEventBus> implements IRootPresenter {

	@Override
	public void onSetBody(IsWidget body) {
		view.setBody(body);
	}

	@Override
	public void onSetToolBar(IsWidget toolbar) {
		view.setToolbar(toolbar);
	}

}
