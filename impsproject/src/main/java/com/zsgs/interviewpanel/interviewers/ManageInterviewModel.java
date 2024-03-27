package com.zsgs.interviewpanel.interviewers;

import java.util.List;

import com.zsgs.interviewpanel.datalayer.InterviewPanelDatabase;
import com.zsgs.interviewpanel.model.Interviewers;
import com.zsgs.interviewpanel.model.Validation;

public class ManageInterviewModel {
	private ManageInterviewersView InterviewersViews;

	public ManageInterviewModel(ManageInterviewersView InterviewersViews) {
		this.InterviewersViews = InterviewersViews;
	}

	public void addInterviewer(Interviewers interviewer) {
		Validation validation = new Validation();
		boolean valid = validation.validName(interviewer.getName());
		if (valid) {
			boolean stat = InterviewPanelDatabase.createInstance().insertInterviewers(interviewer);
			if (stat)
				InterviewersViews.onSuccess();
			else
				InterviewersViews.alert("\nInterviewer Already Exists\n");
		} else {
			InterviewersViews.alert("\nEnter a valid Name ...\n");
		}
	}

	public List<Interviewers> getAllInterviewers() {

		return InterviewPanelDatabase.createInstance().getAllInterviewers();

	}

	public boolean deleteInterviewer(String name) {
		List<Interviewers> arrInterviewers = InterviewPanelDatabase.createInstance().getAllInterviewers();
		for (Interviewers interv : arrInterviewers) {
			if (interv.getName().equals(name)) {
				InterviewPanelDatabase.createInstance().removeInterviewers(interv);
				return true;
			}
		}
		return false;
	}

	public Interviewers searchInterviewers(String name) {
		List<Interviewers> interviewerList = InterviewPanelDatabase.createInstance().getAllInterviewers();
		if (!interviewerList.isEmpty()) {
			for (Interviewers inter : interviewerList) {
				if (inter.getName().equals(name)) {
					// System.out.println("\n"+inter.getInterviewerId()+" ----- "+inter.getName()+"
					// ----- "+inter.getAvailability());//+" ----- "+cand.getStatus()+"\n");
					return inter;
				}
//				else 

			}
			InterviewersViews.alert("\nNo Interviewer found..!!!!\nPlease Enter correct Name...");
		}
		return null;
	}

}
