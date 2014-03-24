package com.github.wreckan.admin.client.mvp;

import com.google.gwt.user.client.ui.IsWidget;

public interface IRootView extends IsWidget {

	public interface IRootPresenter {

		void onSetBody(IsWidget body);

		void onSetToolBar(IsWidget toolbar);

	}

	void setBody(IsWidget body);

	void setToolbar(IsWidget toolbar);

}
