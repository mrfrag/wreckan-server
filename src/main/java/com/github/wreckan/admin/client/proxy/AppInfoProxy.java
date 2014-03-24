package com.github.wreckan.admin.client.proxy;

import com.github.wreckan.server.AppInfoLocator;
import com.github.wreckan.server.model.AppInfo;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = AppInfo.class, locator = AppInfoLocator.class)
public interface AppInfoProxy extends EntityProxy {

	public String getAppName();

	public void setAppName(String appName);

	public String getAccessKey();

	public void setAccessKey(String accessKey);

	public boolean isStoreReports();

	public void setStoreReports(boolean storeReports);

}
