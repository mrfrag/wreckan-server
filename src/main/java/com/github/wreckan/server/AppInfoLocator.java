package com.github.wreckan.server;

import com.github.wreckan.server.model.AppInfo;
import com.github.wreckan.server.repository.JpaRepository;
import com.google.web.bindery.requestfactory.shared.Locator;

public class AppInfoLocator extends Locator<AppInfo, Long> {

	@Override
	public AppInfo create(Class<? extends AppInfo> clazz) {
		return new AppInfo();
	}

	@Override
	public AppInfo find(Class<? extends AppInfo> clazz, Long id) {
		return JpaRepository.INSTANCE.findOne(id);
	}

	@Override
	public Class<AppInfo> getDomainType() {
		return AppInfo.class;
	}

	@Override
	public Long getId(AppInfo domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(AppInfo domainObject) {
		return domainObject.getVersion();
	}

}
