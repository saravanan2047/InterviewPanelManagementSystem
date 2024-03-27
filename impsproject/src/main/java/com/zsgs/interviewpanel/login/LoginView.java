package com.zsgs.interviewpanel.login;

import java.util.Scanner;

import com.zsgs.interviewpanel.InterviewPanelMain;
import com.zsgs.interviewpanel.managepanel.ManagePanelView;

public class LoginView {
	private LoginModel loginModel;
	Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginModel = new LoginModel(this);

	}

	public void initCreation() {
		System.out.println("--- " + InterviewPanelMain.getInstance().getAppName() + " --- \n\t version: "
				+ InterviewPanelMain.getInstance().getVersion());
		init();

	}

	public void init() {

		
		System.out.println("****************** WELCOME TO IPMS ****************");
		System.out.println("\n************* Please Login To Proceed ************");
		System.out.println("\nEnter the user name:");
		String userName = scanner.next();
		System.out.println("Enter the password:");
		String password = scanner.next();
		loginModel.validateUser(userName, password);
	}

	public void onSuccess() {
		System.out.println("\n\n**************** Login successful *****************\n\n --------- Welcome To "
				+ InterviewPanelMain.getInstance().getAppName() + " ---------\n  " + "\n\t\t ----- V"
				+ InterviewPanelMain.getInstance().getVersion() + "----\n  ");
		// ManagePanelView managePanelView = new ManagePanelView();
		new ManagePanelView().init(); // calling the next package method
	}

	public void showAlert(String message) {
		System.out.println(message);
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("Do you try again? \n\n Type Yes/No");
		
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			init();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n ---- Thanks You ----");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForLogin();
		}
	}
}
