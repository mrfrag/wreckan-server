package com.github.wreckan.admin.client.mvp.views;

import com.github.gwtbootstrap.client.ui.Column;
import com.github.wreckan.admin.client.mvp.IRootView;
import com.github.wreckan.admin.client.mvp.IRootView.IRootPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class RootView extends AbstractView<IRootPresenter> implements IRootView {

	private static RootViewUiBinder uiBinder = GWT.create(RootViewUiBinder.class);

	interface RootViewUiBinder extends UiBinder<Widget, RootView> {
	}

	@UiField
	protected Column body, toolBar;

	public RootView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setBody(IsWidget body) {
		this.body.clear();
		this.body.add(body);
	}

	@Override
	public void setToolbar(IsWidget toolbar) {
		this.toolBar.clear();
		this.toolBar.add(toolbar);
	}

}
