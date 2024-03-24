package com.zsgs.interviewpanel.managepanel;

import java.util.Scanner;

import com.zsgs.interviewpanel.candidates.CandidatesView;
import com.zsgs.interviewpanel.conductinterview.ConductInterView;
import com.zsgs.interviewpanel.conductinterview.ConductInterviewModel;
import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.interviewers.ManageInterviewersView;
import com.zsgs.interviewpanel.login.LoginView;
import com.zsgs.interviewpanel.model.Company;
import com.zsgs.interviewpanel.model.Interviewers;

public class ManagePanelView {
	private Managepanelmodel managePanelModel;

	public ManagePanelView() {
		managePanelModel = new Managepanelmodel(this);
	}

	public void init() {
		managePanelModel.initateSetUp();
	}

	public void onSuccess() {

		System.out.println("\n******************************************");
		System.out.println("\nInterview Panel Completed successfully...\n");
		System.out.println(
				"Current Company Name : " + InterviewPanelDatabase.createInstance().getCompany().getCompanyName());
		System.out.println("\n******************************************");
		onComplete();

	}

	public void onComplete() {
		// user option
		Scanner scan = new Scanner(System.in);
		try {
			while (true) {
				System.out.println(
						"Select option for further Step :\n\n1) Manage Candidates \n2) Manage Interviewers \n3) Conduct Interview \n4) Check Interview Result \n5) Log Out \n0) EXIT  ");
				int choice = scan.nextInt();
//				System.out.println("Please Enter again......................");
				switch (choice) {
				case 1:
					new CandidatesView().initAdd();
					break;
				case 2:
					new ManageInterviewersView().initAdd();
					break;
				case 3:
					new ConductInterView().conductInit();
					break;
				case 4:
					new ConductInterView().showResult();// still need to develop
					break;
				case 5:
					System.out.println("\n************ Logged Out Successfully ************\n\n");
					new LoginView().init();
					break;
				case 0:
					System.out.println("~~~~~~~~~~~~ ` Thanks For Using `~~~~~~~~~~~");
					break;
				default:
					System.out.println("\n Please Enter a Valid Choice\n");
				}
				if (choice == 0)
					System.exit(choice);

			}
		} catch (Exception e) {
			System.out.println("\n!!!! Please Enter valid choice !!!!!!\n");
			onComplete();
		}

	}

	public void initiateSetUp() {
		try {
			Company company = new Company();
			// System.out.println(company.getCompanyName());
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Company ID : (Ex: 1245)");
			int id = scan.nextInt();
			company.setId(id);
			scan.nextLine();
			System.out.println("Enter the Company Name : (Ex: zoho pvt ltd) ");
			String companyName = scan.nextLine();
			company.setCompanyName(companyName);
			System.out.println("Enter the company Email : (Ex: zsgs2024@gmail.com) ");
			String email = scan.next();
			company.seteMail(email.toLowerCase());
			System.out.println("Enter the company Address : (Ex: tenkasi TN 627581) ");
			scan.nextLine();
			String address = scan.nextLine();
			company.setAddress(address);
			System.out.println("Enter the phone number : (Ex: 987456310 or 987-654-3210 or (123) 456-7890 ");
			String mobileno = scan.next();
			company.setMobileNo(mobileno);

			managePanelModel.createCompanyPanel(company);
		}

		catch (Exception e) {
			System.out.println("\nEnter the corrrect details....\n\n");
			initiateSetUp();
		}
	}

	public void showAlert(String string) {
		System.out.println("\n" + string + "\n");
		initiateSetUp();
	}

}
