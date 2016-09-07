package com.dmv.publicrecords.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver_info")
public class Driver {

	@Id
	@Column(name = "dl")
	private String licenceNumber;
	@Column(name = "driver_name")
	private String name;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "exp_date")
	private String expiryDate;
	@Column(name = "points")
	private String points;
	@Column(name = "tickets")
	private String tickets;
	@Column(name = "issuing_state")
	private String issuingState;

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getTickets() {
		return tickets;
	}

	public void setTickets(String tickets) {
		this.tickets = tickets;
	}

	public String getIssuingState() {
		return issuingState;
	}

	public void setIssuingState(String issuingState) {
		this.issuingState = issuingState;
	}

}
