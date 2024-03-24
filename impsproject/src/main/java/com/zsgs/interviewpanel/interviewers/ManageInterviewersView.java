package com.zsgs.interviewpanel.interviewers;

import java.util.List;
import java.util.Scanner;

import com.zsgs.interviewpanel.managepanel.ManagePanelView;
import com.zsgs.interviewpanel.model.Company;
import com.zsgs.interviewpanel.model.Interviewers;

public class ManageInterviewersView {
	private Company company;
	private ManageInterviewModel interviewModel;
	private Scanner scan = new Scanner(System.in);

	public ManageInterviewersView() {
		interviewModel = new ManageInterviewModel(this);
		company = new Company();
	}
//	public void showCompanyName()
//	{
//		System.out.println("Current Company name : "+InterviewPanelDatabase.createInstance().getCompany().getCompanyName());
//	}

	public void initAdd() {
		try {
			while (true) {
//			scan.nextLine();
				System.out.println(
						"Select Option for Further Process....\n1) Add Interviewer \n2) Show All Interviewers \n3) Search Interviewer \n4) Delete Interviewer \n5) Show Candidates List \n6) Go To Main Page\n");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					addInterviewer();
					break;
				case 2:
					allInterviewer();
					break;
				case 3:
					searchInterviewer();
					break;
				case 4:
					removeInterviewer();
					break;
				case 5:
					System.out
							.println("\nThis feature will be released in future updates\nThanks foryour patience\n\n");
					// showCandidatesList();
					break;
				case 6:
					System.out.println("Redirecting to Main Page .....\n");
					new ManagePanelView().onComplete();
					break;
				default:
					System.out.println("\nEnter a valid Option.\n");
				}
				if (choice == 6)
					break;
			}
		} catch (Exception e) {
			System.out.println("Enter valid choice");
			initAdd();
		}

	}

	public void addInterviewer() {

//		System.out.println("Adding Interviewer..");
		try {
			Interviewers interviewer = new Interviewers();

			System.out.println("Enter the Iterviewer ID :");
			String interviewerId = scan.next();
			interviewer.setInterviewerId(interviewerId);

			System.out.println("Enter the Interviewer Name:");
			String interviewerName = scan.next();
			interviewer.setName(interviewerName);

			System.out.println("Enter the Interviewer  Availability :");
			String availability = scan.next();
			interviewer.setAvailability(availability);

			interviewModel.addInterviewer(interviewer);
		} catch (Exception e) {
			System.out.println("Enter the corect details..\n");
			// initAdd();
		}
	}

	public void removeInterviewer() {
		System.out.println("Enter the Interviewers Name :");
		String name = scan.next();
		if (interviewModel.deleteInterviewer(name)) {
			System.out.println("\nInterviewer Deleted Successfully...\n");
			initAdd();
		} else {
			System.out.println("\nCandidate Not Found Please Enter Correct Email.\n");
			initAdd();
		}
	}

	public void allInterviewer() {
		List<Interviewers> interviewersList = interviewModel.getAllInterviewers();
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf(" %10s %21s %25s", "Interviewer ID", "Interviewer Name", "Interviewer Availability");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
//	        System.out.println()
		if (!interviewersList.isEmpty()) {
			for (Interviewers Interv : interviewersList) {
//					System.out.println("\n"+Interv.getName() + "\t" + Interv.getAvailability() + "\t" + Interv.getInterviewerId()+"\n");
				System.out.format("%10s %25s %20s", Interv.getInterviewerId(), Interv.getName(),
						Interv.getAvailability());
				System.out.println();
				// System.out.println("\n"+cand.getName() + "\t" + cand.getEmail() + "\t" +
				// cand.getStatus()+"\n");
				System.out.println("-------------------------------------------------------------------------");

			}
			initAdd();
		} else {
			System.out.println("\nEnter details of the candidates first..!!!\n");
			addInterviewer();
		}
	}

	public void searchInterviewer() {
		System.out.println("Enter the Interviewer Name :");
		String name = scan.next();
		Interviewers interviewer = interviewModel.searchInterviewers(name);
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf(" %10s %20s %22s", "Interviewer ID", "Interviewer Name", "Interviewer Availability");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
		if (interviewer != null) {
			System.out.format("%10s %25s %20s", interviewer.getInterviewerId(), interviewer.getName(),
					interviewer.getAvailability());
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");

		} else {
			System.out.println("\nFirst Add Interviewer to Display\n");
			initAdd();
		}

	}

//	public  void showCandidatesList() {
//		List<Interviewers> interviewerList=interviewModel.getAllInterviewers();
//		if(!interviewerList.isEmpty()) {
//		for(Interviewers inter:interviewerList)
//		{
//			List<Candidates> completedCand=inter.getInterviewCompleted();
//			if(!completedCand.isEmpty()) 
//			{
//				System.out.print(inter.getName()+" conducted Interview for :\t\n");
//				System.out.println("-------------------------------------------------------------------------");
//				System.out.printf(" %10s %20s %22s", "Candidate Name", "Candidate Email", "Candidate Status");
//				System.out.println();
//				System.out.println("-------------------------------------------------------------------------");
//			for(Candidates c:completedCand)
//			{
//				System.out.format("%10s %25s %20s",c.getName(),c.getEmail(),c.getStatus()+"\n");
//				System.out.println("-------------------------------------------------------------------------");
//				//System.out.println(c.getName()+"\t"+c.getEmail()+"\t"+c.getStatus()+"\n");
//			}
//			
//		}
//			else
//			{
//				System.out.println("Interview Not yet Conducted!!!!1"
//						+ "\nFirst Conduct Inteview..\n");
//				break;
//			}
//		}
//		}
//		else
//		{
//			System.out.println("\n~~~~~~~~~~~~~~ First Add Interviewers ~~~~~~~~~~~~~~~~~~~\n");
//		}
//		
//	}
	public void onSuccess() {
		System.out.println("\nInterviewers Added Successfully\n");
	}

	public void alert(String string) {
		System.out.println(string);
	}

}
