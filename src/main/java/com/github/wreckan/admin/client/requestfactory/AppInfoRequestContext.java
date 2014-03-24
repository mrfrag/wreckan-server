package com.github.wreckan.admin.client.requestfactory;

import java.util.List;

import com.github.wreckan.admin.client.proxy.AppInfoProxy;
import com.github.wreckan.server.RequestFactoryService;
import com.github.wreckan.server.RequestFactoryServiceLocator;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value = RequestFactoryService.class, locator = RequestFactoryServiceLocator.class)
public interface AppInfoRequestContext extends RequestContext {

	Request<List<AppInfoProxy>> list();

	Request<AppInfoProxy> save(AppInfoProxy proxy);

	Request<Void> delete(AppInfoProxy proxy);

//	InstanceRequest<AppInfoProxy, Void> persist();

}
