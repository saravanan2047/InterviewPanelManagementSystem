package com.zsgs.interviewpanel.login;

public class LoginModel {
	private LoginView loginView;

	LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void validateUser(String userName, String password) {
		if (isValidName(userName)) {
			if (isValidPassword(password)) {
				loginView.onSuccess();
			} else {
				loginView.showAlert("Invalid Password");
			}

		} else {
			loginView.showAlert("Invalid UserName \nEnter the Credential Again.");
		}

	}

	private boolean isValidName(String name) {
		return name.equals("zoho");
	}

	private boolean isValidPassword(String password) {
		return password.equals("zoho123");
	}

}
