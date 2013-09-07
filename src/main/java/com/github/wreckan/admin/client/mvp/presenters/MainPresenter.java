package com.github.wreckan.admin.client.mvp.presenters;

import com.github.wreckan.admin.client.WreckanEventBus;
import com.github.wreckan.admin.client.mvp.IMainView;
import com.github.wreckan.admin.client.mvp.IMainView.IMainPresenter;
import com.github.wreckan.admin.client.mvp.views.MainView;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.LazyPresenter;

@Presenter(view = MainView.class)
public class MainPresenter extends LazyPresenter<IMainView, WreckanEventBus> implements IMainPresenter {

	@Override
	public void onStart() {
		eventBus.setBody(view);
	}

}
