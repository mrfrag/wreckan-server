package com.github.wreckan.server.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class AppInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Timestamp version;

	private String appName;

	private String accessKey;

	private boolean storeReports;

	@ElementCollection
	private List<String> reportRecipients;

	@ElementCollection
	private List<String> emailReportFields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getVersion() {
		return version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public boolean isStoreReports() {
		return storeReports;
	}

	public void setStoreReports(boolean storeReports) {
		this.storeReports = storeReports;
	}

	public List<String> getReportRecipients() {
		return reportRecipients;
	}

	public void setReportRecipients(List<String> reportRecipients) {
		this.reportRecipients = reportRecipients;
	}

	public List<String> getEmailReportFields() {
		return emailReportFields;
	}

	public void setEmailReportFields(List<String> emailReportFields) {
		this.emailReportFields = emailReportFields;
	}

	public void addEmailReportField(String field) {
		if (emailReportFields == null) {
			emailReportFields = new ArrayList<String>();
		}
		emailReportFields.add(field);
	}

	public void addReportRecipient(String recipientEmail) {
		if (reportRecipients == null) {
			reportRecipients = new ArrayList<String>();
		}
		reportRecipients.add(recipientEmail);
	}

}
