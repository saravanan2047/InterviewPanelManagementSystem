package com.zsgs.interviewpanel.conductinterview;

import java.util.List;
import java.util.Scanner;

import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.model.Candidates;

public class ConductInterView {
	private ConductInterviewModel interviewModel;
	private static Scanner scan = new Scanner(System.in);

	public ConductInterView() {
		interviewModel = new ConductInterviewModel(this);
	}

	public void conductInit() {
		System.out.println("\nStarting the Interview....\n");
		System.out.println("Enter the Email id :");
		String emailId = scan.next();
		Candidates candidate = interviewModel.isPresent(emailId);
		if (candidate != null) {
			nextProcess(candidate);
		}

	}

	private void nextProcess(Candidates candidate) {
		interviewModel.addCandidateToInterviewer(candidate);
	}

	public void showResult() {
		System.out.println("Displaying the Status of candidates..");
		List<Candidates> candListStatus = InterviewPanelDatabase.createInstance().getAllCandidates();
		if (!candListStatus.isEmpty()) {
//			System.out.println("Name");
			System.out.println("-------------------------------------------------------------------------");
			System.out.printf(" %10s %20s %22s", "Candidate Name", "candidate Email", "Candidate Status ");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
//	        System.out.println();
			for (Candidates cand : candListStatus) {
				System.out.format("%10s %25s %20s", cand.getName(), cand.getEmail(), cand.getStatus());
				System.out.println();
				// System.out.println("\n"+cand.getName() + "\t" + cand.getEmail() + "\t" +
				// cand.getStatus()+"\n");
				System.out.println("-------------------------------------------------------------------------");
			}
		} else {
			System.out.println("Please conduct interview First");
		}

	}

	public void alert(String string) {
		System.out.println(string);
	}

	public void message(String string) {
		System.out.println(string);
	}

}
