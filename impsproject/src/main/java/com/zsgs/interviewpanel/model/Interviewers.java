package com.zsgs.interviewpanel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Interviewers {

	String interviewerId;
	String name;
	String availability;
	List<Candidates> interviewCompleted = new ArrayList<Candidates>();

	// conatructor
	public Interviewers() {

	}

	public String getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(String interviewerId) {
		this.interviewerId = interviewerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
//
//	public void setInterviewCompleted(List<Candidates> candidates) {
//		this.interviewCompleted = candidates;
//	}

	public void setInterviewCompletedCandidates(Candidates candidate) {
		interviewCompleted.add(candidate);
	}

	public List<Candidates> getInterviewCompleted() {
		return interviewCompleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Interviewers that = (Interviewers) o;
		return Objects.equals(interviewerId, that.interviewerId) && Objects.equals(name, that.name)
				&& Objects.equals(interviewCompleted, this.interviewCompleted)
				&& Objects.equals(availability, that.availability);
	}

	@Override
	public int hashCode() {
		return Objects.hash(interviewerId, name, availability, interviewCompleted);
	}
}
