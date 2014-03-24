package com.github.wreckan.server.repository;

import java.util.Map;

import com.github.wreckan.server.model.AppInfo;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public enum DataStoreRepository {

	INSTANCE;

	private DatastoreService datastoreService;

	private DataStoreRepository() {
		datastoreService = DatastoreServiceFactory.getDatastoreService();
	}

	public void saveReportData(AppInfo appInfo, Map<String, String> reportData) {
		Entity entity = new Entity(appInfo.getAccessKey(), System.currentTimeMillis());
		for (String key : reportData.keySet()) {
			entity.setProperty(key, reportData.get(key));
		}
		datastoreService.put(entity);
	}

}
