package com.zsgs.interviewpanel.model;

import java.util.Objects;

public class Candidates {
	String id;
	String name;
	String email;
	String phoneNumber;
	String status;

	public Candidates() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Candidates that = (Candidates) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email)
				&& Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, email, phoneNumber, status);
	}
}
