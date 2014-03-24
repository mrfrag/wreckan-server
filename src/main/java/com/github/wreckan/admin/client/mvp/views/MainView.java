package com.github.wreckan.admin.client.mvp.views;

import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.wreckan.admin.client.mvp.IMainView;
import com.github.wreckan.admin.client.mvp.IMainView.IMainPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class MainView extends AbstractView<IMainPresenter> implements IMainView {

	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	@UiField
	protected TextBox appName;
	@UiField
	protected TextBox accessKey;
	@UiField
	protected CheckBox storeReports;
	@UiField
	protected TextBox reportRecipients;
	@UiField
	protected TextBox emailReportFields;
	@UiField
	protected SubmitButton addAppButton;

	@Override
	public void createView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public HasClickHandlers getSubmitButton() {
		return addAppButton;
	}

	public HasText getAppName() {
		return appName;
	}

	public HasText getAccessKey() {
		return accessKey;
	}

	public HasValue<Boolean> getStoreReports() {
		return storeReports;
	}

	public HasText getReportRecipients() {
		return reportRecipients;
	}

	public HasText getEmailReportFields() {
		return emailReportFields;
	}

	@UiHandler("addAppButton")
	public void addAppButtonHandler(ClickEvent event) {
		getPresenter().createApp(appName.getText(), accessKey.getText(), storeReports.getValue());
	}

}
