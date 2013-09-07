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

import lombok.Data;

@Data
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
