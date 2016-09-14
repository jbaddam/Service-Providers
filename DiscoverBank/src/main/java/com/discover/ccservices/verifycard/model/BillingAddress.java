package com.discover.ccservices.verifycard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_address")
public class BillingAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ba_id", unique = true, nullable = false)
	private int id;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private int zip;

	@Override
	public String toString() {
		return "BillingAddress [ba_id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
	}

	public int getBa_id() {
		return id;
	}

	public void setBa_id(int ba_id) {
		this.id = ba_id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
}
