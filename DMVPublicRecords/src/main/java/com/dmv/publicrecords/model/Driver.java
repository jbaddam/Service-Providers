package com.dmv.publicrecords.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jagan Reddy
 * Driver Entity Class
 */
@Entity
@Table(name = "driver_info")
public class Driver {

	@Id
	@Column(name = "dl")
	private String licenceNumber;
	@Column(name = "driver_name")
	private String name;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "exp_date")
	private Date expiryDate;
	@Column(name = "points")
	private int points;
	@Column(name = "tickets")
	private int tickets;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public String getIssuingState() {
		return issuingState;
	}
	public void setIssuingState(String issuingState) {
		this.issuingState = issuingState;
	}

}
