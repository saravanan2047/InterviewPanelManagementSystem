package com.zsgs.interviewpanel.managepanel;

import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.model.Company;
import com.zsgs.interviewpanel.model.Validation;

public class Managepanelmodel {
	private ManagePanelView managePanelview;
	private Company company;

	public Managepanelmodel(ManagePanelView managePanelview) {
		this.managePanelview = managePanelview;
		company = InterviewPanelDatabase.createInstance().getCompany();
	}

	public void initateSetUp() {
		if (company == null)// || company.getId()==0)
		{
			managePanelview.initiateSetUp();
		} else {
			managePanelview.onComplete();
		}
	}

	public void createCompanyPanel(Company company) {
		Validation valid = new Validation();
		boolean stat = valid.validEmail(company.geteMail()) && valid.validPhoneNo(company.getMobileNo())
				&& valid.validName(company.getCompanyName());

		if (stat) {
			// this.company=company;
			InterviewPanelDatabase.createInstance().insertCompany(company);
			managePanelview.onSuccess();
			// startSetup();
			// value=false;
		} else {
			managePanelview.showAlert("Invalid Company details....... \n\nPlease re enter proper details....\n");
			managePanelview.initiateSetUp();

		}
	}

}
