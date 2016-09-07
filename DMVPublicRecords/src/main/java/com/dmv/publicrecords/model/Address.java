package com.dmv.publicrecords.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "a_id")
	private String addressId;
	@Column(name = "line1")
	private String addressLine1;
	@Column(name = "line2")
	private String addressLine2;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "zip")
	private String zip;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
