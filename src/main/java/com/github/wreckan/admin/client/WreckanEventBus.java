package com.github.wreckan.admin.client;

import com.github.wreckan.admin.client.mvp.presenters.MainPresenter;
import com.github.wreckan.admin.client.mvp.presenters.RootPresenter;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

@Events(startPresenter = RootPresenter.class)
public interface WreckanEventBus extends EventBus {

	@Start
	@Event(handlers = MainPresenter.class)
	public void start();

	@Event(handlers = RootPresenter.class)
	public void setBody(IsWidget body);

}
