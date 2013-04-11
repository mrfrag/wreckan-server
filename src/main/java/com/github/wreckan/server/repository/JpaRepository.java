package com.github.wreckan.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.github.wreckan.server.model.AppInfo;

public enum JpaRepository {

	INSTANCE;

	private EntityManager entityManager;

	private final EntityManagerFactory entityManagerFactory;

	private JpaRepository() {
		entityManagerFactory = Persistence.createEntityManagerFactory("wreckan-unit");
	}

	public AppInfo findAppInfoByAccessKey(String accessKey) {
		TypedQuery<AppInfo> query = entityManager.createQuery("from AppInfo where accessKey=:accessKey", AppInfo.class);
		query.setParameter("accessKey", accessKey);
		return query.getSingleResult();
	}

	public void onDestroyContext() {
		entityManager.close();
	}

	public void onInitContext() {
		entityManager = entityManagerFactory.createEntityManager();
	}

}
