package com.github.wreckan.admin.client.mvp.views;

import com.github.wreckan.admin.client.mvp.IMainView;
import com.github.wreckan.admin.client.mvp.IMainView.IMainPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class MainView extends AbstractView<IMainPresenter> implements IMainView {

	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	@Override
	public void createView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
