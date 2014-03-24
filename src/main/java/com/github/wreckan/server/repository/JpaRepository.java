package com.github.wreckan.server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.github.wreckan.server.model.AppInfo;

public enum JpaRepository {

	INSTANCE;

	private final EntityManager entityManager;

	private JpaRepository() {
		entityManager = Persistence.createEntityManagerFactory("wreckan-unit").createEntityManager();
	}

	public AppInfo findAppInfoByAccessKey(String accessKey) {
		TypedQuery<AppInfo> query = entityManager.createQuery("from AppInfo where accessKey=:accessKey", AppInfo.class);
		query.setParameter("accessKey", accessKey);
		return query.getSingleResult();
	}

	public AppInfo findOne(Long id) {
		return entityManager.find(AppInfo.class, id);
	}

	public void save(AppInfo appInfo) {
		entityManager.persist(appInfo);
	}

	public void remove(AppInfo appInfo) {
		entityManager.remove(appInfo);
	}

	public List<AppInfo> list() {
		TypedQuery<AppInfo> query = entityManager.createQuery("from AppInfo", AppInfo.class);
		return query.getResultList();
	}

}
