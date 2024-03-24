package com.zsgs.interviewpanel.conductinterview;

import java.util.List;

import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.model.Candidates;
import com.zsgs.interviewpanel.model.Interviewers;
import com.zsgs.interviewpanel.model.Validation;

public class ConductInterviewModel {
	private ConductInterView conductInterview;
	private Candidates candidate;
	private Interviewers Interviewer;
	private static int interviewerIndex = 0;
	private static int interviewerIndexNew = 0;

	private Validation validation = new Validation();

	public ConductInterviewModel(ConductInterView conductInterview) {
		this.conductInterview = conductInterview;
	}

	public Candidates isPresent(String emailId) {
		if (validation.validEmail(emailId)) {
			List<Candidates> candList = InterviewPanelDatabase.createInstance().getAllCandidates();
			for (Candidates cand : candList) {
				if (cand.getEmail().equals(emailId)) {
					if (cand.getStatus().equals("pending"))
						return cand;
					else
						conductInterview.alert("\nCandidate Interview was already completed.\n");
					return null;
				}

			}
		} else {
			conductInterview.alert("\nEmail is in-valid.\n");
		}
		return null;
	}

	public void addCandidateToInterviewer(Candidates candidate) {
		List<Interviewers> interviewerList = InterviewPanelDatabase.createInstance().getAllInterviewers();
		if (!interviewerList.isEmpty()) {
			for (Interviewers inter : interviewerList) {
				if (inter.getAvailability().equalsIgnoreCase("yes")) {
					// System.out.println("Candidate is assigned to Interviewer...\n");
					conductInterview.message("\nCandidate is assigned to Interviewer...\n");
					// inter.setInterviewCompleted(candidate);
					interviewerIndexNew = (interviewerIndex + 1) % interviewerList.size();
					InterviewPanelDatabase.createInstance().addCandidatesToInterviewer(candidate, inter,
							interviewerIndex, interviewerIndexNew);
					interviewerIndex = (interviewerIndex + 1) % interviewerList.size();
					conductInterview.message("Interview For the Candidate is Fineshed Successfully...\n");
					break;
				}
			}
		} else {
			conductInterview.alert("Please Add interviewers First To conduct Interview...");
		}
		/*
		 * int interviewerIndex = 0; for (Candidate candidate : candidates) {
		 * Interviewer interviewer = interviewers.get(interviewerIndex);
		 * interviewer.conductInterview(candidate); interviewerIndex = (interviewerIndex
		 * + 1) % interviewers.size(); // Rotate interviewers }
		 */
	}

}
