package com.autocheck.claims.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "vehicle_claims")
public class VehicleClaimsInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "vin")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String vin;
	@Id
	private int claimId;
	private int claimYear;
	private int claimAmount;

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public int getClaimYear() {
		return claimYear;
	}

	public void setClaimYear(int claimYear) {
		this.claimYear = claimYear;
	}

	public int getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	
	@Override
	   public String toString() {
	      return "Vehicle [claimid=" + claimId + ", claimAmount=" + claimAmount + ", claimYear=" + claimYear + ", vin=" + vin + "]";
	   }

}
