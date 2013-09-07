package com.github.wreckan.admin.client.mvp;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;

public interface IMainView extends IsWidget, LazyView {

	public interface IMainPresenter {

		void onStart();

	}

}
