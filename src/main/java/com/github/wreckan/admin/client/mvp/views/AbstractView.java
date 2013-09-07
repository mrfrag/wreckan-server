package com.github.wreckan.admin.client.mvp.views;

import com.google.gwt.user.client.ui.Composite;
import com.mvp4g.client.view.ReverseViewInterface;

public abstract class AbstractView<T> extends Composite implements ReverseViewInterface<T> {

	private T presenter;

	@Override
	public T getPresenter() {
		return presenter;
	}

	@Override
	public void setPresenter(T presenter) {
		this.presenter = presenter;
	}

}
