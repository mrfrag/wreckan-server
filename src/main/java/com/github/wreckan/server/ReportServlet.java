package com.github.wreckan.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datanucleus.util.StringUtils;

import com.github.wreckan.server.model.AppInfo;
import com.github.wreckan.server.repository.DataStoreRepository;
import com.github.wreckan.server.repository.JpaRepository;
import com.google.appengine.repackaged.org.apache.http.HttpStatus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = -7315665239221710559L;

	private Gson gson = new Gson();

	private Type resultMapType = new TypeToken<Map<String, String>>() {
	}.getType();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AppInfo appInfo = getAppInfo(req, resp);
		if (appInfo != null) {
			Map<String, String> report = gson.fromJson(new InputStreamReader(req.getInputStream()), resultMapType);
			try {
				sendEmails(appInfo, report);
			} catch (MessagingException e) {
				setErrorResponse(resp, HttpStatus.SC_INTERNAL_SERVER_ERROR, "Unable to send email: " + e.getMessage());
			}
			if (appInfo.isStoreReports()) {
				DataStoreRepository.INSTANCE.saveReportData(appInfo, report);
			}
		}
	}

	private void sendEmails(AppInfo appInfo, Map<String, String> report) throws MessagingException, UnsupportedEncodingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		MimeMessage msg = new MimeMessage(session);
		msg.setSubject("Error report from an app user for " + appInfo.getAppName());
		msg.setFrom(new InternetAddress("wreckan@pavel.st", "Wreckan crash reporting system."));

		for (String recipient : appInfo.getReportRecipients()) {
			try {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			} catch (Exception e) {
				// TODO log error.
			}
		}

		StringWriter text = new StringWriter();
		PrintWriter print = new PrintWriter(text);
		for (String reportField : appInfo.getEmailReportFields()) {
			if (report.containsKey(reportField)) {
				print.println(reportField + ": " + report.get(reportField));
			}
		}
		msg.setText(text.toString());
		print.close();
		Transport.send(msg);
	}

	private AppInfo getAppInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String accessKey = req.getParameter("accessKey");
		if (StringUtils.isEmpty(accessKey)) {
			setErrorResponse(resp, HttpStatus.SC_BAD_REQUEST, "accessKey is required.");
			return null;
		}
		AppInfo appInfo = JpaRepository.INSTANCE.findAppInfoByAccessKey(accessKey);
		if (appInfo == null) {
			setErrorResponse(resp, HttpStatus.SC_BAD_REQUEST, "Wrong accessKey.");
			return null;
		}
		resp.setStatus(HttpStatus.SC_OK);
		return appInfo;
	}

	private void setErrorResponse(HttpServletResponse resp, int statusCode, String message) throws IOException {
		resp.setStatus(statusCode);
		resp.setContentType("text/plain");
		resp.getWriter().println(message);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		JpaRepository.INSTANCE.onInitContext();
	}

	@Override
	public void destroy() {
		super.destroy();
		JpaRepository.INSTANCE.onDestroyContext();
	}

}
