package com.zsgs.interviewpanel;

import com.zsgs.interviewpanel.login.LoginView;

public class InterviewPanelMain {
	private static InterviewPanelMain interviewpanel;
	private String appName = "Interview Panle";
	private String version = "0.0.1";

	public InterviewPanelMain() {

	}

	public static InterviewPanelMain getInstance() {
		if (interviewpanel == null) {
			interviewpanel = new InterviewPanelMain();
		}
		return interviewpanel;
	}

	public void create() {
		LoginView loginview = new LoginView();
		loginview.init();
	}

	public String getAppName() {
		return interviewpanel.appName;
	}

	public String getVersion() {
		return interviewpanel.version;
	}

	public static void main(String[] args) {
		InterviewPanelMain.getInstance().create();

	}

}
