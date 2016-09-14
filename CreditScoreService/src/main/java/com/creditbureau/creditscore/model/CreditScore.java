package com.creditbureau.creditscore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

/**
 * This is a CreditScore class with the ssn, creditScore properties
 * @author Jude Mariarajan
 *
 */
@Entity
@Table(name = "credit_score_info")
public class CreditScore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ssn")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ssn;
	private int creditScore;
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

}
