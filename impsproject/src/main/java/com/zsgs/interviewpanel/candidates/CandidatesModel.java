package com.zsgs.interviewpanel.candidates;

import java.util.List;

import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.model.Candidates;
import com.zsgs.interviewpanel.model.Validation;

public class CandidatesModel {
	private CandidatesView candidateview;

	public CandidatesModel(CandidatesView candidateview) {
		this.candidateview = candidateview;
	}

	public void setCandidates(Candidates candidate) {
		Validation valid = new Validation();
		boolean validation = valid.validEmail(candidate.getEmail()) && valid.validName(candidate.getName())
				&& valid.validPhoneNo(candidate.getPhoneNumber());
		if (validation) {
			boolean stat = InterviewPanelDatabase.createInstance().insertCandidates(candidate);
			if (stat)
				candidateview.onSuccess();
			else
				candidateview.alert("\nCandidate already present Enter new One\n");
		} else {
			candidateview.alert("\nEnter Correct and Valid details\n");
		}
	}

	public List<Candidates> getAllCandidates() {
		return InterviewPanelDatabase.createInstance().getAllCandidates();
	}

	// for seacrhing candidates
	public Candidates searchCandidate(String email) {
		List<Candidates> candList = InterviewPanelDatabase.createInstance().getAllCandidates();
		if (!candList.isEmpty()) {
			for (Candidates cand : candList) {
				if (cand.getEmail().equals(email)) {
					// System.out.println("\n"+cand.getId()+" ----- "+cand.getName()+" -----
					// "+cand.getEmail()+" ----- "+cand.getStatus()+"\n");
					return cand;
				}

			}
			// candidateview.alert("\nNo user found..!!!!\\nPlease Enter correct Email");

			// System.out.println("\nNo user found..!!!!\nPlease Enter correct Email");
		}
//			else
//			{
//				//candidateview.alert("\\nFirst Add Candidates to Display\\n");
//				System.out.println("\nFirst Add Candidates to Display\n");
//				candidateview.initAdd();
//				
//			}
		return null;

	}

	public boolean deleteCandidate(String email) {
		List<Candidates> arr = InterviewPanelDatabase.createInstance().getAllCandidates();
		for (Candidates cand : arr) {
			if (cand.getEmail().equals(email)) {
				return InterviewPanelDatabase.createInstance().removeCandidate(cand);

			}
		}
		return false;

	}

}
