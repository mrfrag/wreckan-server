package com.github.wreckan.server;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class RequestFactoryServiceLocator implements ServiceLocator {

	private RequestFactoryService requestFactoryService;

	@Override
	public Object getInstance(Class<?> clazz) {
		if (requestFactoryService == null) {
			requestFactoryService = new RequestFactoryService();
		}
		if (clazz.isInstance(requestFactoryService)) {
			return requestFactoryService;
		}
		return null;
	}
}
