package com.github.wreckan.server;

import java.util.List;

import com.github.wreckan.server.model.AppInfo;
import com.github.wreckan.server.repository.JpaRepository;

public class RequestFactoryService {

	public List<AppInfo> list() {
		return JpaRepository.INSTANCE.list();
	}

	public AppInfo save(AppInfo appInfo) {
		JpaRepository.INSTANCE.save(appInfo);
		return appInfo;
	}

	public void delete(AppInfo appInfo) {
		JpaRepository.INSTANCE.remove(appInfo);
	}

}
