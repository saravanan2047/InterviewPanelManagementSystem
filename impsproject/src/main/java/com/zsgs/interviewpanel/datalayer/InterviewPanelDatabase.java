package com.zsgs.interviewpanel.datalayer;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zsgs.interviewpanel.login.LoginView;
import com.zsgs.interviewpanel.model.Candidates;
import com.zsgs.interviewpanel.model.Company;
import com.zsgs.interviewpanel.model.Interviewers;

public class InterviewPanelDatabase {
	private static InterviewPanelDatabase interviewDb;
//	private Interviewers interviewers;
//	private Candidates candidates;
//	private Company company;
	private List<Candidates> candidateList = new ArrayList<>();
	private List<Interviewers> interviewList = new ArrayList<>();
	private String companyFile = "company.json";
	private String candidateFile = "candidate.json";
	private String interviewerFile = "interviewer.json";
//	private File;

	InterviewPanelDatabase() {
	}

	public static InterviewPanelDatabase createInstance() {
		if (interviewDb == null) {
			interviewDb = new InterviewPanelDatabase();
		}
		return interviewDb;
	}

	public void insertCompany(Company company) {
//		this.company = company;
		try {
			File file = new File(companyFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectMapper companyObj = new ObjectMapper();
			companyObj.enable(SerializationFeature.INDENT_OUTPUT);
			companyObj.writeValue(file, company);
		} catch (Exception e) {
			new LoginView().showAlert("Error Occured in adding Company");
		}
	}

	public Company getCompany() {
//		Company companyDetails;
		ObjectMapper companyObj = new ObjectMapper();
		try {

			return companyObj.readValue(new File(companyFile), Company.class);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean insertCandidates(Candidates candidate) {
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			File fileCandidate = new File(candidateFile);
			if (!fileCandidate.exists())
				fileCandidate.createNewFile();
			if (fileCandidate.length() > 0) {// verifying that the length of the file is not empty
				candidateList = candidateObj.readValue(new File(candidateFile), new TypeReference<List<Candidates>>() {});
				for (Candidates cand : candidateList) {
					if (candidate.getEmail().equals(cand.getEmail()))
						return false;
				}
				candidateList.add(candidate);
				candidateObj.writeValue(fileCandidate, candidateList);
				return true;
			} else { // if control comes here it will be first entry so no need to check

				candidateList.add(candidate);
				candidateObj.writeValue(fileCandidate, candidateList);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean insertInterviewers(Interviewers interviewer) {
		ObjectMapper interviewerObj = new ObjectMapper();
		try {
			File fileInterviewer = new File(interviewerFile);
			if (!fileInterviewer.exists())
				fileInterviewer.createNewFile();
			if (fileInterviewer.length() > 0) {// verifying that the length of the file is not empty
				interviewList = interviewerObj.readValue(new File(interviewerFile),
						new TypeReference<List<Interviewers>>() {
						});
				for (Interviewers intrev : interviewList) {
					if (interviewer.getName().equals(intrev.getName()))
						return false;
				}
				interviewList.add(interviewer);
				interviewerObj.writeValue(fileInterviewer, interviewList);
				return true;
			} else { // if control comes here it will be first entry so no need to check
				interviewList.add(interviewer);
				interviewerObj.writeValue(fileInterviewer, interviewList);
				return true;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public List<Candidates> getAllCandidates() {
		// TODO Auto-generated method stub
//		return candidateList;
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			return candidateList = candidateObj.readValue(new File(candidateFile),
					new TypeReference<List<Candidates>>() {
					});
		} catch (Exception e) {
			return null;
		}
	}

	public List<Interviewers> getAllInterviewers() {
		ObjectMapper interviewerObj = new ObjectMapper();
		try {
			return interviewList = interviewerObj.readValue(new File(interviewerFile),
					new TypeReference<List<Interviewers>>() {
					});
		} catch (Exception e) {
			return null;
		}
	}

	public boolean removeCandidate(Candidates cand) {
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			File fileCandidates = new File(candidateFile);
			candidateList = candidateObj.readValue(new File(candidateFile), new TypeReference<List<Candidates>>() {
			});
//			System.out.println("before removing length"+candidateList.size());
			if (candidateList.remove(cand)) {
				candidateObj.writeValue(fileCandidates, candidateList);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void removeInterviewers(Interviewers interv) {
		ObjectMapper interviewerObj = new ObjectMapper();

		try {
			File fileinterviewers = new File(interviewerFile);
			interviewList = interviewerObj.readValue(new File(interviewerFile),
					new TypeReference<List<Interviewers>>() {
					});
			if (interviewList.remove(interv)) {
//				interviewerObj.writer(interviewerFile, interviewList);
				interviewerObj.writeValue(fileinterviewers, interviewList);
			}
		} catch (Exception e) {
		}
	}

	public void addCandidatesToInterviewer(Candidates candidate, Interviewers interviewer, int start, int end) {
		ObjectMapper interviewerObj = new ObjectMapper();
		ObjectMapper candidateObj = new ObjectMapper();
		try {
			File fileinterviewers = new File(interviewerFile);
			File fileCandidates = new File(candidateFile);
			interviewList = interviewerObj.readValue(new File(interviewerFile),
					new TypeReference<List<Interviewers>>() {
					});
			
			for (Candidates cand : candidateList) {
				if (cand.getName().equals(candidate.getName())) {
					cand.setStatus("Completed");
					cand.setInterviewerName(interviewer.getName());
					candidateObj.writeValue(fileCandidates, candidateList);
				}
			}
			interviewList.get(start).setAvailability("no");
			interviewList.get(end).setAvailability("yes");
			interviewList.get(start).setInterviewCompletedCandidates(candidate);
			candidateList = candidateObj.readValue(new File(candidateFile), new TypeReference<List<Candidates>>() {
			});
//			interviewer.setInterviewCompletedCandidates(candidate);
			interviewerObj.writeValue(fileinterviewers, interviewList);
		} catch (Exception e) {

		}

	}
}
