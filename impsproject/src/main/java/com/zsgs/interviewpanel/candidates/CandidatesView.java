package com.zsgs.interviewpanel.candidates;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.interviewers.ManageInterviewersView;
import com.zsgs.interviewpanel.login.LoginView;
import com.zsgs.interviewpanel.managepanel.ManagePanelView;
import com.zsgs.interviewpanel.model.Candidates;

public class CandidatesView {
	private CandidatesModel candidatemodel;
	Scanner scan = new Scanner(System.in);

	public CandidatesView() {
		candidatemodel = new CandidatesModel(this);
		// candidate = new Candidates();
	}

	public void initAdd() {
		try {
			while (true) {
				// scan.nextLine();
				System.out.println(
						"Select the option you want to carry out: \n1) ADD Candidates \n2) Search Candidate \n3) SHOW All Candidates \n4) Remove Candidate \n5) Exit");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					addCandidates();
					break;
				case 2:
					searchCandidates();
					break;
				case 3:
					displayAllCandidates();
					break;
				case 4:
					removeCandidate();
				case 5:
					System.out.println("<~~~~~~~~~~~~~~> Redirecting To Main Page <~~~~~~~~~~~~~~>");
					new ManagePanelView().onComplete();
					break;
				default:
					System.out.println("\n ~~~~~~~~~> Please Enter a Valid Choice <~~~~~~~~ \n");
					break;
				}
				if (choice == 5)
					break;
			}
		} catch (InputMismatchException e) {
			System.out.println("\n!!!! Please Enter valid choice !!!!!!\n");
			initAdd();
//
		}

	}

	public void addCandidates() {
		Candidates candidate = new Candidates();
		try {
			System.out.println("Enter the candidate ID : ");
			String id = scan.next();
			candidate.setId(id);
			System.out.println("Enter the candidate Name: ");
			String name = scan.next();
			candidate.setName(name);
			System.out.println("Enter the candidate Email: ");
			String emial = scan.next();
			candidate.setEmail(emial.toLowerCase());
			System.out.println("Enter the candidate mobile number: ");
			String mobileNo = scan.next();
			candidate.setPhoneNumber(mobileNo);
			System.out.println("Enter the candidate current status: ");
			String stat = scan.next();
			candidate.setStatus(stat.toLowerCase());
			candidatemodel.setCandidates(candidate);

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Enter the details correctly...!!!!\n");
			// addCandidates();
		}
	}

	public void onSuccess() {
		System.out.println("\nCandidate addedd successfully\n\n");
	}

	public void alert(String message) {
		System.out.println(message);
	}

	public void searchCandidates() {
		System.out.println("Enter the Candidate Email Id :");
		String email = scan.next();
		System.out.println("\nThe Result of your search.....");
		Candidates candidate = candidatemodel.searchCandidate(email);

		if (candidate != null) {
			System.out.println("---------------------------------------------------------------------------------");
			System.out.printf(" %10s %20s %22s %22s", "Candidate ID", "Candidate Name", "candidate Email",
					"Candidate Status ");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("\n-->" + candidate.getId() + " ----- " + candidate.getName() + " ----- "
					+ candidate.getEmail() + " ----- " + candidate.getStatus());
			System.out.println("---------------------------------------------------------------------------------");
		} else {
			System.out.println("\nCandidate not found add candidate.\n");
			initAdd();
		}
	}

	public void displayAllCandidates() {
		List<Candidates> candidateList = candidatemodel.getAllCandidates();
		if (!candidateList.isEmpty()) {
//			System.out.println("Name");
			System.out.println("-------------------------------------------------------------------------");
			System.out.printf(" %10s %20s %22s", "Candidate Name", "candidate Email", "Candidate Status ");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
//	        System.out.println();
			for (Candidates cand : candidateList) {
				System.out.format("%10s %25s %20s", cand.getName(), cand.getEmail(), cand.getStatus());
				System.out.println();
				// System.out.println("\n"+cand.getName() + "\t" + cand.getEmail() + "\t" +
				// cand.getStatus()+"\n");
				System.out.println("-------------------------------------------------------------------------");
			}
			initAdd();
		} else {
			System.out.println("\nNo Candidate found..!!!!");// \nPlease Enter correct Email or Add the
																// Candidates....!!!\n");
			System.out.println("\nADD CANDIDATS FIRST...\n");
//			addCandidates();
			initAdd();
		}
	}

	private void removeCandidate() {
		System.out.println("Enter the Candidate Email Id :");
		String email = scan.next();
		boolean stat = candidatemodel.deleteCandidate(email);
		if (stat) {
			System.out.println("\nCandidate Deleted Successfully...\n");
			initAdd();
		} else {
			System.out.println("\nCandidate Not Found Please Enter Correct Email.\n");
			initAdd();
		}

	}

}
